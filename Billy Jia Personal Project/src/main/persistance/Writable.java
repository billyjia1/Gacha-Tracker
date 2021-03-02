package persistance;

import org.json.JSONObject;

public interface Writable {
    //A majority of this code was taken from demo given, altered slightly to fulfil my needs
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
