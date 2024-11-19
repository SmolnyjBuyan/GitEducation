import java.time.LocalDate;

public enum Holiday {
    NO_HOLIDAY(), NEW_YEAR("С Новым Годом!"),
    WOMAN_DAY("С 8 марта!"),
    MAN_DAY("С 23 февраля");

    private String congratulation;

    Holiday(String congratulation) {
        this.congratulation = congratulation;
    }

    Holiday() {
    }

    public static Holiday getHoliday(int dayOfYear) {
        switch (dayOfYear) {
            case 1: return NEW_YEAR;
            case 68: return WOMAN_DAY;
            case 54: return MAN_DAY;
            default: return NO_HOLIDAY;
        }
    }

    public static Holiday getTodayHoliday() {
        return Holiday.getHoliday(LocalDate.now().getDayOfYear());
    }

    public String getCongratulation(){
        return congratulation;
    }
}
