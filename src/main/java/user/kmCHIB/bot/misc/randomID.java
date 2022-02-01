package user.kmCHIB.bot.misc;

public class randomID {
    public long getRand(){
        long leftLimit = 1000000L;
        long rightLimit = 9999999L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return generatedLong;
    }
}
