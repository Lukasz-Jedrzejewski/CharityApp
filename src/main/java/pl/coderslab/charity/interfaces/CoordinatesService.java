package pl.coderslab.charity.interfaces;

import com.byteowls.jopencage.model.JOpenCageLatLng;

public interface CoordinatesService {

    JOpenCageLatLng getData(String street, String city);
}
