package com.lifel.aih.main;

import com.lifel.aih.transform.Transform;
import com.lifel.aih.util.LogUtils;
import org.junit.Test;

public class MainApplication {


    public static void main(String[] args) {
        //原始文件路径
        String originalDirPath = "D:\\lifel\\Library\\AndroidImageHelper\\test\\original";
        String transformDirPath = "D:\\lifel\\Library\\AndroidImageHelper\\test\\transform";
        //旧文件名
        String oldImageName="找货.png";
        //新文件名
        String newImageName="3_test.png";

        Transform.renameAndCopyMultipleFile(originalDirPath,transformDirPath,oldImageName,newImageName);
        LogUtils.log("转换完成");



    }

    @Test
    public void test() {

    }

}
