package com.lifel.aih.transform;

import com.lifel.aih.util.FileUtils;
import com.lifel.aih.util.LogUtils;

/**
 * 图片重命名
 * 本类适用于AndroidStudio中图片资源mipmap-mdpi mipmap-hdpi mipmap-xhdpi mipmap-xxhdpi mipmap-xxxhdpi
 * 的快速重命名及快速复制到工作空间
 */
public class Transform {
    public String tag = this.getClass().getSimpleName();

    /**
     * 单个个文件重命名并且复制到指定文件夹
     *
     * @param oldDirPath  就文件夹
     * @param newDirPath  新文件夹
     * @param oldFileName 就文件名
     * @param newFileName 新文件名
     */
    public static void renameAndCopySingleFile(String oldDirPath, String newDirPath, String oldFileName, String newFileName) {
        renameSingleFile(oldDirPath + "\\" + oldFileName, newFileName);
        copySingleFile(oldDirPath + "\\" + newFileName, newDirPath + "\\" + newFileName);
    }

    /**
     * 多个个文件重命名并且复制到指定文件夹
     *
     * @param oldDirPath  就文件夹
     * @param newDirPath  新文件夹
     * @param oldFileName 就文件名
     * @param newFileName 新文件名
     */
    public static void renameAndCopyMultipleFile(String oldDirPath, String newDirPath, String oldFileName, String newFileName) {
        renameMultipleFile(oldDirPath, oldFileName, newFileName);
        copyMultipleFile(oldDirPath, newDirPath, newFileName);
    }


    /**
     * 多个文件重命名
     *
     * @param oldDirPath  需要重命名的文件夹路径
     * @param oldFileName 旧文件名
     * @param newFileName 新文件名
     */
    public static void renameMultipleFile(String oldDirPath, String oldFileName, String newFileName) {
        //mipmap-mdpi
        renameSingleFile(oldDirPath + "\\mipmap-mdpi\\" + oldFileName, newFileName);
        //mipmap-hdpi
        renameSingleFile(oldDirPath + "\\mipmap-hdpi\\" + oldFileName, newFileName);
        //mipmap-xhdpi
        renameSingleFile(oldDirPath + "\\mipmap-xhdpi\\" + oldFileName, newFileName);
        //mipmap-xxhdpi
        renameSingleFile(oldDirPath + "\\mipmap-xxhdpi\\" + oldFileName, newFileName);
        //mipmap-xxxhdpi
        renameSingleFile(oldDirPath + "\\mipmap-xxxhdpi\\" + oldFileName, newFileName);
    }

    /**
     * 单个文件重命名
     *
     * @param filePath 文件绝对路径
     * @param newName  新文件名
     */
    public static void renameSingleFile(String filePath, String newName) {
        if (!FileUtils.isFileExists(filePath)) {
            LogUtils.log("重命名失败,文件不存在:" + filePath);
            return;
        }
        String newFilePath = FileUtils.getDirName(filePath) + newName;
        if (FileUtils.isFileExists(newFilePath)) {
            LogUtils.log("重命名失败,新文件名已被占用:" + newFilePath);
            return;
        }


        boolean result = FileUtils.rename(filePath, newName);
        String fileNmae = FileUtils.getFileName(filePath);
        if (result) {
            LogUtils.log("重命名成功:" + fileNmae + "->" + newName);
        } else {
            LogUtils.log("重命名失败:" + fileNmae + "->" + newName);
        }
    }

    /**
     * 单个文件复制
     */
    public static void copySingleFile(String oldFilePath, String newFilePath) {
        if (!FileUtils.isFileExists(oldFilePath)) {
            LogUtils.log("复制失败,文件不存在:" + oldFilePath);
            return;
        }

        if (FileUtils.isFileExists(newFilePath)) {
            LogUtils.log("复制失败,新文件已存在,无法复制:" + newFilePath);
            return;
        }
        boolean result = FileUtils.copy(oldFilePath, newFilePath);
        if (result) {
            LogUtils.log("复制成功:" + oldFilePath + "->" + newFilePath);
        } else {
            LogUtils.log("复制失败:" + oldFilePath + "->" + newFilePath);
        }
    }

    /**
     * 多个文件复制
     *
     * @param oldDirPath 旧文件夹路径
     * @param newDirPath 新文件夹路径
     * @param fileName   文件名
     */
    public static void copyMultipleFile(String oldDirPath, String newDirPath, String fileName) {
        //mipmap-mdpi
        copySingleFile(oldDirPath + "\\mipmap-mdpi\\" + fileName, newDirPath + "\\mipmap-mdpi\\" + fileName);
        //mipmap-hdpi
        copySingleFile(oldDirPath + "\\mipmap-hdpi\\" + fileName, newDirPath + "\\mipmap-hdpi\\" + fileName);
        //mipmap-xhdpi
        copySingleFile(oldDirPath + "\\mipmap-xhdpi\\" + fileName, newDirPath + "\\mipmap-xhdpi\\" + fileName);
        //mipmap-xxhdpi
        copySingleFile(oldDirPath + "\\mipmap-xxhdpi\\" + fileName, newDirPath + "\\mipmap-xxhdpi\\" + fileName);
        //mipmap-xxxhdpi
        copySingleFile(oldDirPath + "\\mipmap-xxxhdpi\\" + fileName, newDirPath + "\\mipmap-xxxhdpi\\" + fileName);

    }
}
