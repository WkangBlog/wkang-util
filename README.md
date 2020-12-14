# wkang-util
## 目录
- [说明](#说明)
- [导入项目](#导入项目)
- [工具类介绍](#工具类介绍)
    - [file(文件处理)](#文件处理)
        - [GZIPUtil(通过Gzip算法压缩和解压)](#gziputil通过gzip算法压缩和解压)
    - [network(网络访问及数据格式处理)](#网络访问及数据格式处理)
        - [EmailUtil(邮件发送工具类)](#emailutil邮件发送工具类)
        - [HttpUtil(http请求工具类)](#httputilhttp请求工具类)
        - [UrlParamsUtil（对URL参数处理的工具类）](#urlparamsutil对url参数处理的工具类)
        - [XmlConfUtil(解析XMl配置工具类)](#xmlconfutil解析XMl配置工具类)
    - [QRcode(二维码)](#二维码)
        - [KQRcodel(二维码生成工具类)](#KQRcodel二维码生成工具类)
    - [security(加密解密工具类)](#加密解密工具类)
        - [KMD5(MD5工具类)](#KMD5工具类)
        - [KDecrypt(异或工具类)](#KDecrypt异或工具类)
        - [KSecurity(通用加密工具类)](#KSecurity通用加密工具类)
    - [string(字符串工具类)](#字符串工具类)
        - [LangArabicNumConvertUtil(语言数字与阿拉伯数字转换工具类)](#langarabicnumconvertutil语言数字与阿拉伯数字转换工具类)
        - [DateUtil(时间转换工具类)](#dateutil时间转换工具类)
        - [EncodeDecodeUtil(编码与解码工具类)](#encodedecodeutil编码与解码工具类)
        - [BigDecimalUtil(BigDecimal计算工具类)](#bigdecimalutilbigdecimal计算工具类)
        - [RegexUtil(正则工具类)](#regexutil正则工具类)
        - [LanguageUtil(语言工具类)](#languageutil语言工具类)
        - [StringUtil(字符串工具类)](#stringutil字符串工具类)
    - [others(其他工具类)](#其他工具类)
        - [DeepCopyUtil(深拷贝工具类)](#deepcopyutil深拷贝工具类)
        - [CaptchaUtil(验证码工具类)](#captchautil验证码工具类)
    
## 说明
目前部分代码来自开源项目[CommonUtil](https://github.com/LJWLgl/CommonUtil#LangArabicNumConvertUtil)，对其中不常用做了删减，并添加了自己用的工具类
## maven引用
```
<dependency>
      <groupId>com.github.wkangblog</groupId>
      <artifactId>wkang-util</artifactId>
      <version>1.0.1-RELESE</version>
</dependency>
```
## 工具类介绍
### **文件处理**
- **GZIPUtil(通过Gzip算法压缩和解压)**
    - **compress(String str)**，字符串压缩为GZIP字节数组
    - **compress(String str, String encoding)**，字符串压缩为GZIP字节数组
    - **uncompress(byte[] bytes)**，GZIP解压缩

### **网络访问及数据格式处理**
- **EmailUtil(邮件发送工具类)**
```java
// 发送邮箱配置，授权密码可以去邮件运营商获取
EmailUtil.config(EmailUtil.SMTP_QQ(false), "xxx@qq.com", "xxxxxx");
```
- **HttpUtil(http请求工具类)**
在服务里请求别的接口也是很常见的事
    - **doGet(String url, Map<String, String> queryParam)**，get请求，queryParam是参数
    - **doPost(String url, Map<String, String> params, String json)**，json 请求体内是json字符串
    - ... doPost的重载方法
    
- **UrlParamsUtil（对URL参数处理的工具类）**
    - **String join(Map<String, String> map, String separator)**，将Map转成String, 可以指定分隔符，通常用于拼接URL后面的参数
    - **Map<String, String> split(String paramsPath, String separator)**，解析ulr参数为map
    -  **Map<String, String> split(String paramsPath)**，解析ulr参数为map，这里的separator参数为“=”
    -  **Map<String, String> build(String ... keyValues)**，将keyValues转成Map
    -  **add(Map<String, String> originMap, String ... keyValues)**，在原Map添加keyValues
    
- **xmlconfutil解析XMl配置工具类**
解析工具通过JAXB实现，主要用于xml配置文件的实例化，以及生成配置类javaBean对应的xml
    - **<T> T xml2JBean(Class<?> clazz, InputStream in)**，将xml实例化为T类型实例
    - **void jBean2Xml(Object instance, OutputStream out)**，将配置类实例instance解析为xml

### **二维码**
- **KQRcodel(二维码生成工具类)**
    - **byte[] createQRcode(String url)**，创建二维码
    
### **加密解密工具类**
- **KMD5(MD5工具类)**
    - **String md5(String string)**，计算字符串MD5值
    - **String md5(File file)**，计算文件的 MD5 值
    - **String md5Nio(File file)**，采用nio的方式,计算文件的 MD5 值
    - **String md5(String string, int times)**，对字符串多次MD5加密
    - **String md5(String string, String slat)**，MD5加盐
    
- **KDecrypt(异或工具类)**
    - **decode(String tfilePath, String filePath, String fileName, String password)**，文件加密与解密
    - **String decodeText(String text, String password)**，加密文本
    
- **KSecurity(通用加密工具类)**
    - **String getEncryptedPwd(String password)**，加密
    - **boolean validPassword(String password, String encpassword)**，密码对比
      
### **字符串工具类**
- **LangArabicNumConvertUtil(语言数字与阿拉伯数字转换工具类)**
    - **String lang2ArabicNumber(String word, String majorLocale)**，将语言数字转成阿拉伯数字，目前只支持英语和中文的转换（参数说明，majorLocale：中文zh或英语en）
    - **String arabic2LangNumber(String word, String majorLocale)**，将阿拉伯数字转成语言数字，会转成带进制的语言数字
    - **String arabic2NoDecimalLangNumber(String word, String majorLocale)**，将阿拉伯数字转成语言数字，会转成不带进制的语言数字
    
- **DateUtil(时间转换工具类)**
在日常开发过程中，我们进程会需要把Date转成String，或者把String转成Date，该工具类大致上能满足我们日志开发需要：
    - **getCurrentDate()**，获取当期日志，只包含日期
    - **calcIntervalDays(Date date1, Date date2)**，计算两个日期间隔的天数
    - **dayOfWeek(Date date)**，返回data对应的是星期几
    - **getTodayMinutes()**，获取今天的分钟数，如今天18:05，则返回1805
    - **getIntervalDate(Date time, int days)**，获取指定间隔天数的日期，比如昨天 getIntervalDate(new Date(), -1)
    - **dateToShortDateString(Date date)**，将date转成String，输出String只包含年月日
    - **dateToString(Date date)**， 将date转成String，输出String包含年月日时分秒
    - **stringToDate(String dateStr)**，将String转成Date，默认时区东八区，TimeZone.getTimeZone("Asia/Shanghai")
    - **dateToVoString(Date date)** ，后端经常会根据传入Date生成View层的String传给前端，该方法计算成相应中文，会例如：
        - 1分钟内：刚刚
        - 超过1分钟并在1小时内：某分钟前 （1分钟前）
        - 超过1小时并在当日内：某小时前（1小时前）
        - 昨天：昨天 + 小时分钟（昨天 08:30）
        - 昨天之前并在当年内：某月某日 + 小时分钟（1月1日 08:30）
        - 隔年：某年某月某日 + 小时分钟（2017年1月1日 08:30）
    
- **EncodeDecodeUtil(编码与解码工具类)**
    - **encodeWithMD5(String str)**， 对字符串进行MD5加密
    - **encodeWithSHA1(String str)**，对字符串进行SHA1加密
    - **encodeWithSHA256(String str)**，对字符串进行SHA-256加密
    - **encode(String algorithm, String str)**，通过指定算法对字符串加密
    - **encodeBase64(String str)**，对字符串进行Base64编码
    - **decodeBase64(String str)**，对字符串进行Base64解码
    - **encodeUrl(String str)**，对URL编码
    - **decodeUrl(String str)**，对URL解码
    
- **LanguageUtil(语言工具类)**
多语言场景工具类，可以借助下面工具类判断字符是哪种locale
    - **isOnlyLetter(String str)**，是否只有字母
    - **isLetter(String str)**，是否有字母和空格
    - **isChinese(String str)**，是否只有汉字和空格
    - **isLetterAndNumber(String str)**，是否只有字母、数字和空格
    - **isChineseAndNumber(String str)**，是否只有汉字、数字和空格
    - **isKoreanAndNumber(String str)**，是否只有韩语、数字和空格
    - **isJapanAndNumber(String str)**，是否只有日文和数字
    
- **RegexUtil(正则工具类)**
    - **isMobileExact(CharSequence input)**，是否是手机号
    - **isEmail(CharSequence input)**，是否是email
    - **isURL(CharSequence input)**，是否是URL
    - **isIP(CharSequence input**，是否是IP
    - **isMatch(String regex, CharSequence input)**，是否匹配正则表达式
    - **getMatches(String regex, CharSequence input)**，获取正则表达式的部分
    - ...
    
- **StringUtil(字符串工具类)**
对于字符串工具类，优先推荐使用org.apache.commons.lang3下的StringUtils以及java.lang.String的自带方法，本工具类只是补充了一些个别方法。
    - **String replaceString(String str, Map<String, String> oldNewMap)**， 批量替换字符
    - **String subArr2String(int i, int j, char[] arr)**，将字符数组的子集合成新的字符串
    - **String subArr2String(int i, int j, String[] arr, String separator)**，将字符串数组的子串合成一个新的字符串
    - **double castDouble(Object obj, double defaultValue)**，转为double类型 ，如果obj为null或者空字符串或者格式不对则返回defaultValue
    - **double cast...(Object obj, double defaultValue)**，转换成对应的基础类型
    
### **其他工具类**
- **BigDecimalUtil(BigDecimal计算工具类)**
在和钱打交道的服务里，经常会用到BigDecimal类，下面提供一些他的计算方法
    - **subtract(double x, double y)**
    - **add(double x, double y)**
    - **multiply(double x, double y)**
    - **divide(double x, double y, int scale)**
    - **roundUp(double val)**，近似处理，向上取整
    - **roundUp(double val, int scale)**， 近似处理，向上取整，scale保留点的位数
    - **roundDown(double val)**
    - **roundDown(double val, int scale)**
    
- **DeepCopyUtil(深拷贝工具类)**
    - **Object depthClone(Object srcObj)**，单个对象的深拷贝，通过序列化与反序列的方式实现，所以srcObj对应的需实现java.io.Serializable接口
    - **<T> List<T> listDepthClone(List<T> list)**，多个对象的深拷贝，srcObj对应的需实现java.io.Serializable接口


	 	

