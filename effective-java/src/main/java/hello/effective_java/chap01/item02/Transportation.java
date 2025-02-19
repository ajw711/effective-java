package hello.effective_java.chap01.item02;

import lombok.Getter;

@Getter
public class Transportation extends Trip{

    private final Vehicle vehicle;
    public enum Vehicle{
        Train, Car, Airplane, Ship
    }
    private Transportation(Builder builder) {
        super(builder);
        vehicle = builder.vehicle;
    }

    public static class Builder extends Trip.Builder<Builder>{

        private final Vehicle vehicle;

        public Builder (Vehicle vehicle){
            this.vehicle = vehicle;
        }
        @Override
        public Transportation build(){
            return new Transportation(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
