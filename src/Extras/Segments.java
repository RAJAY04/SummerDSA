package Extras;

import java.util.ArrayList;
import java.util.List;

public class Segments {
    public static void main(String[] args) {
        String message = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus";
        List<String> segments = segments(message);

        for (String segment : segments) {
            System.out.println(segment);
        }
    }

    private static final int MAX_SEGMENT_LENGTH = 160; // Maximum SMS segment length
    private static final int SUFFIX_LENGTH = 5; // Length of the suffix "(x/y)"

    public static List<String> segments(String message) {
        List<String> segments = new ArrayList<>();
        int messageLength = message.length();

        if (messageLength <= MAX_SEGMENT_LENGTH) {
            segments.add(message);
            return segments;
        }

        int totalSegments = (int) Math.ceil((double) messageLength / (MAX_SEGMENT_LENGTH - SUFFIX_LENGTH));

        int start = 0;

        for (int i = 1; i <= totalSegments; i++) {
            int segmentEnd = Math.min(start + (MAX_SEGMENT_LENGTH - SUFFIX_LENGTH), messageLength);

            while (segmentEnd > start && message.charAt(segmentEnd - 1) != ' ') {
                segmentEnd--;
            }

            if (segmentEnd == start) {
                segmentEnd = Math.min(start + (MAX_SEGMENT_LENGTH - SUFFIX_LENGTH), messageLength);
            }

            String segment = message.substring(start, segmentEnd).trim() + String.format(" (%d/%d)", i, totalSegments);
            segments.add(segment);

            start = segmentEnd;

            if (start >= messageLength) {
                break;
            }

            while(start < messageLength && message.charAt(start) == ' ') {
                start++;
            }
        }

        return segments;
    }
}