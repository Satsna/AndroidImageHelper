# AndroidImageHelper
适用于AndroidStudio中图片资源mipmap-mdpi mipmap-hdpi mipmap-xhdpi mipmap-xxhdpi mipmap-xxxhdpi  的快速重命名及快速复制到工作空间

#简单实用方式

        //原始文件路径
        String oldDirPath = "D:\\lifel\\Library\\AndroidImageHelper\\test\\original";
        String newDirPath = "D:\\lifel\\Library\\AndroidImageHelper\\test\\transform";
        //旧文件名
        String oldImageName="NB.png";
        //新文件名
        String newImageName="1_test.png";

        Transform.renameAndCopyMultipleFile(oldDirPath,newDirPath,oldImageName,newImageName);
        LogUtils.log("转换完成");
