import java.text.SimpleDateFormat
import java.util.TimeZone

def call(String name) {
    // Set desired time zone (e.g., IST)
    def timeZone = TimeZone.getTimeZone("Asia/Kolkata")
    
    // Get current date & time with time zone
    def now = new Date()

    def dateFormat = new SimpleDateFormat("yyyy-MM-dd")
    def timeFormat = new SimpleDateFormat("HH:mm:ss")
    dateFormat.setTimeZone(timeZone)
    timeFormat.setTimeZone(timeZone)

    def date = dateFormat.format(now)
    def time = timeFormat.format(now)

    // Load HTML template from resources
    def template = libraryResource('index.html')

    // Replace placeholders
    template = template
        .replace('${name}', name)
        .replace('${date}', date)
        .replace('${time}', time)

    // Write the final index.html into the workspace
    writeFile file: 'index.html', text: template

    echo "index.html generated for ${name} at ${date} ${time}"
}
