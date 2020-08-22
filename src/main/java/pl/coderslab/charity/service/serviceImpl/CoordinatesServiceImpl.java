package pl.coderslab.charity.service.serviceImpl;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.service.CoordinatesService;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Override
    public JOpenCageLatLng getData(String street, String city) {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("4a83bf1d08dc45479e8370def4ce0ce3");
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(street, city);
        request.setLanguage("Polish");

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition(); // get the coordinate pair of the first result

        return firstResultLatLng;


    }
}
