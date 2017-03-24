package com.example.sadiela.app1;

/**
 * Created by sadie.la on 3/22/2017.
 */
public interface FragmentCommunicator {
    void setCaptureData(Integer capNum, String loc, String date);
    void setCarapaceData(double strCLmin, double strCLnt, double strCW, double curCLmin, double curCLnt, double curCW);
    void setOtherData(double headDep, double headWid, double headLen, double bodyDep);
}
