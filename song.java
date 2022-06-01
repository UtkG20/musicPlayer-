public class song {
    String title;
    double duration;
    public song(String title, double duration)
    {
        this.title= title;
        this.duration= duration;
    }
    public String get_title() {
        return title;
    }

    public double get_duration() {
        return duration;
    }

    public String to_String()
    {
        return "song:"+title+"\n duration:"+duration;
    }

}
