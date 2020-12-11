package com.wkang.security;

import java.io.*;

/**
 * 加解密工具：第一次加密，执行第二次解密（异或算法）
 * wkang
 * 2020/12/11 16:25
 */
public class KDecrypt {
	/**
	 *  文件加密与解密
	 * @param tfilePath //源文件的位置
	 * @param filePath  //解密后文件的位置
	 * @param fileName  //源文件的名字
	 * @param password //密码
	 * @throws Exception 异常
	 */
	public static void decode(String tfilePath, String filePath, String fileName, String password) throws Exception {
		File file = new File(tfilePath, fileName); // 源文件
		InputStream is = new FileInputStream(file);
		writeToLocal(filePath + File.separator + fileName, is, password); // 要解密的文件
		is.close();
	}

	/**
	 * 流写入本地文件
	 * 
	 * @param destination 路径
	 * @param input 文件流
	 * @throws IOException 异常
	 */
	private static void writeToLocal(String destination, InputStream input, String password) throws IOException {

		byte[] textChars = new byte[1024];// 临时数据存放的数组
		byte[] bytes2 = new byte[1024 + 256];// 真正需要写出的字节数组
		FileOutputStream downloadFile = new FileOutputStream(destination);

		byte[] pwdChars = password.getBytes();

		int index;
		int k = 0;// 密码计时器
		int j = 0;
		boolean flagLast = false;

		while ((index = input.read(textChars)) != -1) {
			j = 0;

			for (int i = 0; i < index; i++) {

				if (textChars[i] == 13) {// 13代表回车
					if (i + 1 < index && textChars[i + 1] == 10) {
						continue;
					}

					if (i + 1 == index) {
						flagLast = true;
						continue;
					}
				}

				if (flagLast && i == 0) { // 需要将13解密，写入到新文件
					if (textChars[i] != 10) {
						byte temp2 = (byte) (13 ^ pwdChars[k]); // 绝对不可能是10
						if ((int) temp2 == 26 || (int) temp2 == 0 || (int) temp2 == -1) {
							temp2 = 13;
						}
						bytes2[j] = temp2;
						j++;
						k++;
						if (k == pwdChars.length) {
							k = 0;
						}
					}
					flagLast = false;// 只要不是最后一个字符，肯定会走到
				}

				byte temp = (byte) (textChars[i] ^ pwdChars[k]); // temp：读取的字节与密码异或的结果
				if ((int) temp == 26 || (int) temp == 0 || (int) temp == -1) {// 26：'m'和'w'异或的结果，0：0，
																				// -1：文件结尾，这3种特殊情况不加密
					temp = textChars[i];
				}

				if ((int) temp == 10) {// 10：换行
					bytes2[j] = (byte) 13;
					j++;
				}
				bytes2[j] = temp;
				j++;
				k++;
				if (k == pwdChars.length) {
					k = 0;
				}
			}
			downloadFile.write(bytes2, 0, j);
			downloadFile.flush();
		}
		if (flagLast) { // 需要将13解密，写入到新文件
			byte temp3 = (byte) (13 ^ pwdChars[k]); // 绝对不可能是10
			if ((int) temp3 == 26 || (int) temp3 == 0 || (int) temp3 == -1) {
				temp3 = 13;
			}
			bytes2[0] = temp3;
			downloadFile.write(bytes2, 0, 1);
			downloadFile.flush();
		}

		downloadFile.close();
	}

    /**
     * 加密文本
     * @param text 文本
     * @param password 密码
     * @return 密文或原文
     */
	public static String decodeText(String text, String password){
		byte[] pwdChars = password.getBytes();
		byte[] textChars = text.getBytes();
		int index = textChars.length;
		byte[] bytes = new byte[index];// 真正需要写出的字节数组
		int k = 0;// 密码计时器
		int j = 0;
		for (byte textChar : textChars) {
			byte temp = (byte) (textChar ^ pwdChars[k]); // temp：读取的字节与密码异或的结果
			if ((int) temp == 26 || (int) temp == 0 || (int) temp == -1) {// 26：'m'和'w'异或的结果，0：0，
				// -1：文件结尾，这3种特殊情况不加密
				temp = textChar;
			}
			if ((int) temp == 10) {// 10：换行
				bytes[j] = (byte) 13;
			}
			bytes[j] = temp;
			j++;
			k++;
			if (k == pwdChars.length) {
				k = 0;
			}
		}
		return new String(bytes);
	}
}