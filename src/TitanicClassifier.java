public class TitanicClassifier {
    
        public static boolean DIED = true;
        public static boolean SURVIVED = false;

	public static boolean survived(Titanic.Passenger passenger) {
                switch(passenger.sex()) {
                    case MALE:
                        if(passenger.fare() < 10) return DIED;
                        if(passenger.fare() < 30) {
                            if(passenger.age() <10) {
                                if(passenger.siblings() <= 1) return SURVIVED;
                                return DIED;
                            }
                            if(passenger.age()<50 && passenger.age() > 30) {
                                if(passenger.pclass() == Titanic.Class.FIRST) return SURVIVED;
                            }
                            return DIED;
                        }
                        
                        if(passenger.fare() < 60) {
                            if(passenger.age() <5) return SURVIVED;
                            if(passenger.age() <30 && passenger.age() > 20) return SURVIVED;
                            return DIED;
                        }
                        if(passenger.fare() < 80) {
                            if(passenger.port() == Titanic.Port.CHERBOURG) return SURVIVED;
                            return DIED;
                        }
                        if(passenger.age() < 5) return SURVIVED;
                        if(passenger.age()<50 && passenger.age() > 30) return SURVIVED;
                        return DIED;

    
                    case FEMALE:
                        if(passenger.fare() >60) return SURVIVED;
                        if(passenger.fare() <10) {
                            if(passenger.age() <20) return SURVIVED;
                            return DIED;
                        }
                        if(passenger.fare() < 30) {
                            if(passenger.pclass() != Titanic.Class.THIRD) return SURVIVED;
                            return SURVIVED; // no good option :(
                        }
                        if(passenger.fare() < 60) {
                            if(passenger.pclass() == Titanic.Class.THIRD) return DIED;
                            return SURVIVED;
                        }
                }
                
		return DIED;
	}

}
