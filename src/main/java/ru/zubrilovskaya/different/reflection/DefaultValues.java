package ru.zubrilovskaya.different.reflection;

public class DefaultValues {
    int valueInt;
    float valueFloat;
    double valueDouble;
    String valueString;
    boolean valueBoolean;
    long valueLong;
    short valueShort;
    char valueChar;
    byte valueByte ;
    Object valueObject;

    public DefaultValues(BuilderDefault builderDefault) {
        this.valueInt = builderDefault.valueInt;
        this.valueFloat = builderDefault.valueFloat;
        this.valueDouble = builderDefault.valueDouble;
        this.valueString = builderDefault.valueString;
        this.valueBoolean = builderDefault.valueBoolean;
        this.valueLong = builderDefault.valueLong;
        this.valueShort = builderDefault.valueShort;
        this.valueChar = builderDefault.valueChar;
        this.valueByte = builderDefault.valueByte;
        this.valueObject = builderDefault.valueObject;
    }

    public static class BuilderDefault{
        private int valueInt;
        private float valueFloat;
        private double valueDouble;
        private String valueString;
        private boolean valueBoolean;
        private long valueLong;
        private short valueShort;
        private char valueChar;
        private byte valueByte;
        private Object valueObject;

        public BuilderDefault setInt(int valueInt) {
            this.valueInt = valueInt;
            return this;
        }

        public BuilderDefault setFloat(float valueFloat) {
            this.valueFloat = valueFloat;
            return this;
        }

        public BuilderDefault setDouble(double valueDouble) {
            this.valueDouble = valueDouble;
            return this;
        }

        public BuilderDefault setString(String valueString) {
            this.valueString = valueString;
            return this;
        }

        public BuilderDefault setBoolean(boolean valueBoolean) {
            this.valueBoolean = valueBoolean;
            return this;
        }

        public BuilderDefault setLong(long valueLong) {
            this.valueLong = valueLong;
            return this;
        }

        public BuilderDefault setShort(short valueShort) {
            this.valueShort = valueShort;
            return this;
        }

        public BuilderDefault setChar(char valueChar) {
            this.valueChar = valueChar;
            return this;
        }

        public BuilderDefault setByte(byte valueByte) {
            this.valueByte = valueByte;
            return this;
        }
        public BuilderDefault setObject(Object valueObject) {
            this.valueObject = valueObject;
            return this;
        }

        public DefaultValues build(){
            return new DefaultValues(this);
        }
    }

    public  Object getDefaultValue(Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return valueInt;
        } else if (type == float.class || type == Float.class) {
            return valueFloat;
        } else if (type == double.class || type == Double.class) {
            return valueDouble;
        } else if (type == String.class) {
            return valueString;
        } else if (type == boolean.class || type == Boolean.class) {
            return valueBoolean;
        } else if (type == long.class || type == Long.class) {
            return valueLong;
        } else if (type == short.class || type == Short.class) {
            return valueShort;
        } else if (type == char.class || type == Character.class) {
            return valueChar;
        } else if (type == byte.class || type == Byte.class) {
            return valueByte;
        } else if (type == Object.class) {
            return valueObject;
        }
        return null;
    }
}
