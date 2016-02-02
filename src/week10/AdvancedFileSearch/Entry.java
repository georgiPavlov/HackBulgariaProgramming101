package week10.AdvancedFileSearch;

/**
 * Created by georgipavlov on 02.02.16.
 */
public class Entry {

    private boolean newThread =false;
    private String link;


        private  boolean directory;



        public Entry(boolean newThread, boolean directory, String link) {
            this.newThread = newThread;
            this.link = link;

            this.directory = directory;


        }

        public boolean isNewThread() {
            return newThread;
        }

        public String getLink() {
            return link;
        }

        public boolean isDirectory() {
            return directory;
        }
    }


