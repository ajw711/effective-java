package hello.effective_java.chap01.item02;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Busan extends Trip{

    public enum Destination{
        Mountain, Beach
    }

    private final Destination destination;

    private Busan(Builder builder){
        super(builder);
        destination = builder.destination;
    }

    public static class Builder extends Trip.Builder<Builder>{
        private final Destination destination;

        public Builder(Destination destination){
            this.destination = Objects.requireNonNull(destination);
        }

        @Override
        public Busan build() {
            return new Busan(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }



}
