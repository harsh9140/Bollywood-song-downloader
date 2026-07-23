import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class WikipediaDownloader implements Runnable{
    private  String keyword;
    public WikipediaDownloader(){
    }
    public WikipediaDownloader(String keyword){
        this.keyword=keyword;
    }public void run() {
// 1.Get clean keywords
    //2.get the url for wikipidea
    //3.Make a get requests to wikipedia
    //4.parsing the useful results using json
    //5. Showing results.
    if (this.keyword == null || this.keyword.length()==0) {
        return;
    }
//    step 1
    this.keyword = this.keyword.trim().replaceAll("[ ]","_");
//   step2
    String wikiUrl=getWikipediaUrlForQuery(this.keyword);
    try {
//   step 3
    String wikipediaResponseHTML=HttpURLConnectionExample.sendGet(wikiUrl);
    System.out.println(wikipediaResponseHTML);
//    step4
        Document document= Jsoup.parse(wikipediaResponseHTML,"https://en.wikipedia.org/wiki/");
        Elements childElements=document.body().select(".mw-empty-elt > *");
        int state=0;
        for (Element childElement:childElements){

            if (state==0){
                if (childElement.tagName().equals("table")){
                    state=1;
                }
            }else if (state==1){
                if (childElement.tagName().equals("p")){
                    state=2;
                }
            }
            //System.out.println(childElement.tagName());
        }
    }
    catch (Exception e){
        e.printStackTrace();}
}
private String getWikipediaUrlForQuery(String cleanKeyword) {
   return "https://en.wikipedia.org/wiki/"+cleanKeyword;
}
    public static void main(String[] args){
    //ThreadManager taskManager=new TaskManager(20);
    WikipediaDownloader wikipediaDownloader=new WikipediaDownloader("Albert Einstein");
    //taskManager.waitTillQueueIsFreeAndAddTask(wikipediaDownloader);
        Thread thread = new Thread(wikipediaDownloader);
        thread.start();
    }
    }