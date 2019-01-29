package com.lumos.alexa.encryption;

import java.util.Collections;
import java.util.Map;

import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.lumos.alexa.utils.Constants;

/**
 * Cipher class.
 * Usage: encrypt & decrypt data.
 * @author lumos
 *
 */
public class Cipher {

  private Cipher() {}
  
  private static String keyArn = System.getenv(Constants.KMS);

  /**
   * <b> Description </b>: Encrypts a given String.
   * @param data - The string to be encrypted.
   * @return The string encrypted with AWS KMS.
   */
  public static String encrypt(String data) {

    AwsCrypto crypto = new AwsCrypto();
    KmsMasterKeyProvider prov = new KmsMasterKeyProvider(keyArn);
    Map<String, String> context = Collections.singletonMap(
        System.getenv(Constants.EncryptionContext), "titleNumber");
    return crypto.encryptString(prov, data, context).getResult();
  }

  
  /**
   * <b> Description </b>: Decrypts a given String.
   * @param data - The string to be decrypted.
   * @return The plaintext string.
   */
  public static String decrypt(String data) {

    AwsCrypto crypto = new AwsCrypto();
    KmsMasterKeyProvider prov = new KmsMasterKeyProvider(keyArn);
    Map<String, String> context = Collections.singletonMap(
        System.getenv(Constants.EncryptionContext), "titleNumber");
    CryptoResult<String, KmsMasterKey> decryptResult = crypto.decryptString(prov, data);

    // Validate decryption result (Key ID + Context)
    if (!decryptResult.getMasterKeyIds().get(0).equals(keyArn)) {
      throw new IllegalStateException("Wrong key ID!");
    }

    for (final Map.Entry<String, String> e : context.entrySet()) {
      if (!e.getValue().equals(decryptResult.getEncryptionContext().get(e.getKey()))) {
        throw new IllegalStateException("Wrong Encryption Context!");
      }
    }
    return decryptResult.getResult();
  }
}
