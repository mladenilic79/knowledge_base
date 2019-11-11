package swingRepository.zadatak12;

public class Model {

    public static VehicleCategory[] categories = {
        new VehicleCategory() {
            {
                id = 0;
                name = "Tanks";
                vehicles = new Vehicle[]{
                    new Vehicle() {
                        {
                            name = "Tiger";
                            description = "http://en.wikipedia.org/wiki/Tiger I";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "Panther";
                            description = "http://en.wikipedia.org/wiki/Panther_tank";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "Chi nu";
                            description = "http://en.wikipedia.org/wiki/Type_3_Chi-Nu";
                        }
                    }
                };
            }
        },
        new VehicleCategory() {
            {
                id = 1;
                name = "Airplanes";
                vehicles = new Vehicle[]{
                    new Vehicle() {
                        {
                            name = "F16";
                            description = "http://en.wikipedia.org/wiki/General_Dynamics_F-16_Fighting_Falcon";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "Su27";
                            description = "http://en.wikipedia.org/wiki/Sukhoi_Su-27";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "Mig29";
                            description = "http://en.wikipedia.org/wiki/Mikoyan_MiG-29";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "Su25";
                            description = "https://sr.wikipedia.org/sr-ec/%D0%A1%D1%83%D1%85%D0%BE%D1%98_%D0%A1%D1%83-25";
                        }
                    }
                };
            }
        },
        new VehicleCategory() {
            {
                id = 2;
                name = "Ships";
                vehicles = new Vehicle[]{
                    new Vehicle() {
                        {
                            name = "Kirov-class";
                            description = "https://en.wikipedia.org/wiki/Kirov-class_battlecruiser";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "Slava-class";
                            description = "https://en.wikipedia.org/wiki/Slava-class_cruiser";
                        }
                    },
                    new Vehicle() {
                        {
                            name = "USS Ticonderoga";
                            description = "https://en.wikipedia.org/wiki/USS_Ticonderoga_(CG-47)";
                        }
                    },
                };
            }
        },
    };
}
