package com.junesoon.search.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public  class EncryptUtil {

	private final static String MD5 = "MD5";
	private final static String DES = "DES";
	
	/**
	 * MD5�������ܷ���
	 * @param insString ��Ҫ���ܵ��ַ���
	 * @return ���ܺ���ַ���
	 */
	public static String MD5Encode(String insString) {
		
		//���巵���ַ����������ַ�
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		try{
			//��������ַ���ת�����ֽ�
			byte[] btInput=insString.getBytes();	
			//��ȡMd5ժҪ�㷨��MessageDigest����
			MessageDigest messageDigest=MessageDigest.getInstance(MD5);
			//ʹ���ƶ����ֽڸ���ժҪ
			messageDigest.update(btInput);
			//��ȡ����
			byte[] btOutput=messageDigest.digest();
			//������ת����ʮ�����Ƶ��ַ�����ʽ
			int len=btOutput.length;
			char str[]=new char[len*2];
			int k=0;
			for(int i=0;i<len;i++){
				byte b=btOutput[i];
				str[k++]=hexDigits[b>>>4&0xf];
				str[k++]=hexDigits[b&0xf];
			}
			return new String(str);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
     * Description ���ݼ�ֵ���м���
     * @param data 
     * @param key  ���ܼ�byte����
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) {
        byte[] bt;
        String strs=null;
		try {
			bt = encrypt(data.getBytes(), key.getBytes());
			strs=new BASE64Encoder().encode(bt);
			return strs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
 
    /**
     * Description ���ݼ�ֵ���н���
     * @param data
     * @param key  ���ܼ�byte����
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key){
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf; 
        byte[] bt;
		try {
			buf = decoder.decodeBuffer(data);
			bt = decrypt(buf,key.getBytes());
			return new String(bt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        
    }
 
    /**
     * Description ���ݼ�ֵ���м���
     * @param data
     * @param key  ���ܼ�byte����
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // ����һ�������ε������Դ
        SecureRandom sr = new SecureRandom();
 
        // ��ԭʼ��Կ���ݴ���DESKeySpec����
        DESKeySpec dks =new DESKeySpec(key);
 
        // ����һ����Կ������Ȼ��������DESKeySpecת����SecretKey����
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher����ʵ����ɼ��ܲ���
        Cipher cipher = Cipher.getInstance(DES);
 
        // ����Կ��ʼ��Cipher����
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    /**
     * Description ���ݼ�ֵ���н���
     * @param data
     * @param key  ���ܼ�byte����
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // ����һ�������ε������Դ
        SecureRandom sr = new SecureRandom();
 
        // ��ԭʼ��Կ���ݴ���DESKeySpec����
        DESKeySpec dks = new DESKeySpec(key);
 
        // ����һ����Կ������Ȼ��������DESKeySpecת����SecretKey����
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher����ʵ����ɽ��ܲ���
        Cipher cipher = Cipher.getInstance(DES);
 
        // ����Կ��ʼ��Cipher����
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
	
}
