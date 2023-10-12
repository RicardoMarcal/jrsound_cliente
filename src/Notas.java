public final class Notas {
    public static final float X = 0F;
    public static final float C = 16.35F;
    public static final float CS = 17.32F;
    public static final float D = 18.35F;
    public static final float DS = 19.45F;
    public static final float E = 20.60f;
    public static final float F = 21.83F;
    public static final float FS = 23.12F;
    public static final float G = 24.50F;
    public static final float GS = 25.96F;
    public static final float A = 27.50F;
    public static final float AS = 29.14F;
    public static final float B = 30.87F;

    public static float getNota(float nota, int oitava){
        return (float) (nota * Math.pow(2, oitava));
    }
}
