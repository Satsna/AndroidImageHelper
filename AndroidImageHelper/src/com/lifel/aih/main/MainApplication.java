package com.lifel.aih.main;

import com.lifel.aih.transform.Transform;
import com.lifel.aih.util.LogUtils;

public class MainApplication {


    public static void main(String[] args) {
        //旧文件夹路径
        String oldDirPath = "D:\\lifel\\Library\\AndroidImageHelper\\test\\original";
		//新文件夹路径
        String newDirPath = "D:\\lifel\\Library\\AndroidImageHelper\\test\\transform";
        //旧文件名
        String oldImageName="NB.png";
        //新文件名
        String newImageName="1_test.png";

        Transform.renameAndCopyMultipleFile(oldDirPath,newDirPath,oldImageName,newImageName,1);
        LogUtils.log("转换完成");

    }

}
