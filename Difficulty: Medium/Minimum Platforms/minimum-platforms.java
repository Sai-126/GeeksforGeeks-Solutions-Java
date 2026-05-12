import java.util.Arrays;

class Solution {
    // Renamed to match the driver's 'obj.minPlatform' call
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;

        // Step 1: Sort both arrival and departure arrays independently
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 0;
        int max_platforms = 0;
        
        int i = 0; // Pointer for arrivals
        int j = 0; // Pointer for departures

        // Step 2: Use two pointers to move through the timeline
        while (i < n && j < n) {
            // If the next event is an arrival
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }
            // If the next event is a departure
            else {
                plat_needed--;
                j++;
            }

            // Keep track of the peak number of platforms
            max_platforms = Math.max(max_platforms, plat_needed);
        }

        return max_platforms;
    }
}
