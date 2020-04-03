package softuni.exam.service;

import softuni.exam.models.entity.Plane;

public interface PlaneService {

    boolean areImported();

    String readPlanesFileContent() ;
	
	String importPlanes();

    Plane getPlaneByRegisterNumber(String registerNumber);
}
