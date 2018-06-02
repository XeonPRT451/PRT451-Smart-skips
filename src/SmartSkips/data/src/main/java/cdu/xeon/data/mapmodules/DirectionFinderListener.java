package cdu.xeon.data.mapmodules;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import cdu.xeon.data.mapmodules.Route;

    public interface DirectionFinderListener {
        void onDirectionFinderStart();
        void onDirectionFinderSuccess(List<Route> route);
    }

