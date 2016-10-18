package com.tour.util;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.springframework.stereotype.Component;


@Component("geomUtil")
public class GeomUtil {
	 public Geometry wktToGeometry(String wktPoint) {
	        WKTReader fromText = new WKTReader();
	        Geometry geom = null;
	        try {
	            geom = fromText.read(wktPoint);
	        } catch (ParseException e) {
	            throw new RuntimeException("Not a WKT string:" + wktPoint);
	        }
	        return geom;
	    }
}
