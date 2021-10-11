package com.wkang.QRcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 *  二维码生成工具
 *  wkang
 *  2020/7/2 20:16
 *  update 2021/10/11
 */
public class KQRcode {
    /**
     * 二维码生成
     * @param width 宽度，建议使用300
     * @param height 高度，建议使用300
     * @param url 链接
     * @param logoUrl logo链接
     * @return 二维码图片
     */
    public static byte[] createQRcode(int width,int height, String url,String logoUrl) {
        String type = "png";
        // 定义二维码的配置，使用HashMap
        HashMap hints = new HashMap();
        // 字符集，内容使用的编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 容错等级，H、L、M、Q
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 边距，二维码距离边的空白宽度
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            // 生成二维码对象，传入参数：内容、码的类型、宽高、配置
            BufferedImage bufferedImage = getQRCODEBufferedImage(url, BarcodeFormat.QR_CODE, width, height, hints);
            bufferedImage = setMatrixLogo(bufferedImage, logoUrl);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, type, byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static BufferedImage setMatrixLogo(BufferedImage matrixImage,String logoUrl) throws IOException{
         //读取二维码图片，并构建绘图对象
        Graphics2D g2 = matrixImage.createGraphics();
        int matrixWidth = matrixImage.getWidth();
        int matrixHeigh = matrixImage.getHeight();
        BufferedImage logo = null;
        if (logoUrl != null){
            URL url = new URL(logoUrl); //声明url对象
            URLConnection connection = url.openConnection(); //打开连接
            connection.setDoOutput(true);
            logo = ImageIO.read(connection.getInputStream());
        }

        //开始绘制图片前两个、/5*2/5*2 后/5
        g2.drawImage(logo,matrixWidth/5*2,matrixHeigh/5*2, matrixWidth/5, matrixHeigh/5, null);
        g2.dispose(); //执行刷出返回带logo二维码
        matrixImage.flush() ;
        return matrixImage ;

    }

    private static final int QRCOLOR = 0xFF000000;   //默认是黑色
    private static final int BGWHITE = 0xFFFFFFFF;   //背景颜色
    public static BufferedImage getQRCODEBufferedImage(String content, BarcodeFormat barcodeFormat, int width, int height, Map<EncodeHintType, ?> hints)
    {
        MultiFormatWriter multiFormatWriter = null;
        BitMatrix bm = null;
        BufferedImage image = null;
        try
        {
            multiFormatWriter = new MultiFormatWriter();
            // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
            bm = multiFormatWriter.encode(content, barcodeFormat, width, height, hints);
            int w = bm.getWidth();
            int h = bm.getHeight();
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
            for (int x = 0; x < w; x++)
            {
                for (int y = 0; y < h; y++)
                {
                    image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
                }
            }
        }
        catch (WriterException e)
        {
            e.printStackTrace();
        }
        return image;
    }
}
