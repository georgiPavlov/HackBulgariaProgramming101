package week08;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by georgipavlov on 22.01.16.
 */
public class WebReaderTest {

    @Before
    public void TestStart(){

    }
    
    @Test
    public void TestLinks(){
        System.out.println("starting");
        WebReader a = new WebReader();
        String q = "\n" +
                "<!DOCTYPE html>\n" +
                "<!--[if IE 7]>\n" +
                "<html class=\"ie ie7\" lang=\"en-US\">\n" +
                "<![endif]-->\n" +
                "<!--[if IE 8]>\n" +
                "<html class=\"ie ie8\" lang=\"en-US\">\n" +
                "<![endif]-->\n" +
                "<!--[if !(IE 7) & !(IE 8)]><!-->\n" +
                "<html lang=\"en-US\">\n" +
                "<!--<![endif]-->\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width\">\n" +
                "\t<title>Javac.bg | Блогът на Явор Томов</title>\n" +
                "\t<link rel=\"profile\" href=\"http://gmpg.org/xfn/11\">\n" +
                "\t<link rel=\"pingback\" href=\"http://javac.bg/xmlrpc.php\">\n" +
                "\t<!--[if lt IE 9]>\n" +
                "\t<script src=\"http://javac.bg/wp-content/themes/twentyfourteen/js/html5.js\"></script>\n" +
                "\t<![endif]-->\n" +
                "\t<link rel=\"alternate\" type=\"application/rss+xml\" title=\"Javac.bg &raquo; Feed\" href=\"http://javac.bg/?feed=rss2\" />\n" +
                "<link rel=\"alternate\" type=\"application/rss+xml\" title=\"Javac.bg &raquo; Comments Feed\" href=\"http://javac.bg/?feed=comments-rss2\" />\n" +
                "\t\t<script type=\"text/javascript\">\n" +
                "\t\t\twindow._wpemojiSettings = {\"baseUrl\":\"http:\\/\\/s.w.org\\/images\\/core\\/emoji\\/72x72\\/\",\"ext\":\".png\",\"source\":{\"concatemoji\":\"http:\\/\\/javac.bg\\/wp-includes\\/js\\/wp-emoji-release.min.js?ver=4.3.2\"}};\n" +
                "\t\t\t!function(a,b,c){function d(a){var c=b.createElement(\"canvas\"),d=c.getContext&&c.getContext(\"2d\");return d&&d.fillText?(d.textBaseline=\"top\",d.font=\"600 32px Arial\",\"flag\"===a?(d.fillText(String.fromCharCode(55356,56812,55356,56807),0,0),c.toDataURL().length>3e3):(d.fillText(String.fromCharCode(55357,56835),0,0),0!==d.getImageData(16,16,1,1).data[0])):!1}function e(a){var c=b.createElement(\"script\");c.src=a,c.type=\"text/javascript\",b.getElementsByTagName(\"head\")[0].appendChild(c)}var f,g;c.supports={simple:d(\"simple\"),flag:d(\"flag\")},c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.simple&&c.supports.flag||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener(\"DOMContentLoaded\",g,!1),a.addEventListener(\"load\",g,!1)):(a.attachEvent(\"onload\",g),b.attachEvent(\"onreadystatechange\",function(){\"complete\"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);\n" +
                "\t\t</script>\n" +
                "\t\t<style type=\"text/css\">\n" +
                "img.wp-smiley,\n" +
                "img.emoji {\n" +
                "\tdisplay: inline !important;\n" +
                "\tborder: none !important;\n" +
                "\tbox-shadow: none !important;\n" +
                "\theight: 1em !important;\n" +
                "\twidth: 1em !important;\n" +
                "\tmargin: 0 .07em !important;\n" +
                "\tvertical-align: -0.1em !important;\n" +
                "\tbackground: none !important;\n" +
                "\tpadding: 0 !important;\n" +
                "}\n" +
                "</style>\n" +
                "<link rel='stylesheet' id='twentyfourteen-lato-css'  href='https://fonts.googleapis.com/css?family=Lato%3A300%2C400%2C700%2C900%2C300italic%2C400italic%2C700italic&#038;subset=latin%2Clatin-ext' type='text/css' media='all' />\n" +
                "<link rel='stylesheet' id='genericons-css'  href='http://javac.bg/wp-content/themes/twentyfourteen/genericons/genericons.css?ver=3.0.3' type='text/css' media='all' />\n" +
                "<link rel='stylesheet' id='twentyfourteen-style-css'  href='http://javac.bg/wp-content/themes/twentyfourteen/style.css?ver=4.3.2' type='text/css' media='all' />\n" +
                "<!--[if lt IE 9]>\n" +
                "<link rel='stylesheet' id='twentyfourteen-ie-css'  href='http://javac.bg/wp-content/themes/twentyfourteen/css/ie.css?ver=20131205' type='text/css' media='all' />\n" +
                "<![endif]-->\n" +
                "<script type='text/javascript' src='http://javac.bg/wp-includes/js/jquery/jquery.js?ver=1.11.3'></script>\n" +
                "<script type='text/javascript' src='http://javac.bg/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.2.1'></script>\n" +
                "<link rel=\"EditURI\" type=\"application/rsd+xml\" title=\"RSD\" href=\"http://javac.bg/xmlrpc.php?rsd\" />\n" +
                "<link rel=\"wlwmanifest\" type=\"application/wlwmanifest+xml\" href=\"http://javac.bg/wp-includes/wlwmanifest.xml\" /> \n" +
                "<meta name=\"generator\" content=\"WordPress 4.3.2\" />\n" +
                "<style type=\"text/css\" id=\"syntaxhighlighteranchor\"></style>\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"home blog masthead-fixed list-view full-width grid\">\n" +
                "<div id=\"page\" class=\"hfeed site\">\n" +
                "\t\n" +
                "\t<header id=\"masthead\" class=\"site-header\" role=\"banner\">\n" +
                "\t\t<div class=\"header-main\">\n" +
                "\t\t\t<h1 class=\"site-title\"><a href=\"http://javac.bg/\" rel=\"home\">Javac.bg</a></h1>\n" +
                "\n" +
                "\t\t\t<div class=\"search-toggle\">\n" +
                "\t\t\t\t<a href=\"#search-container\" class=\"screen-reader-text\" aria-expanded=\"false\" aria-controls=\"search-container\">Search</a>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<nav id=\"primary-navigation\" class=\"site-navigation primary-navigation\" role=\"navigation\">\n" +
                "\t\t\t\t<button class=\"menu-toggle\">Primary Menu</button>\n" +
                "\t\t\t\t<a class=\"screen-reader-text skip-link\" href=\"#content\">Skip to content</a>\n" +
                "\t\t\t\t<div class=\"nav-menu\"></div>\n" +
                "\t\t\t</nav>\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t<div id=\"search-container\" class=\"search-box-wrapper hide\">\n" +
                "\t\t\t<div class=\"search-box\">\n" +
                "\t\t\t\t<form role=\"search\" method=\"get\" class=\"search-form\" action=\"http://javac.bg/\">\n" +
                "\t\t\t\t<label>\n" +
                "\t\t\t\t\t<span class=\"screen-reader-text\">Search for:</span>\n" +
                "\t\t\t\t\t<input type=\"search\" class=\"search-field\" placeholder=\"Search &hellip;\" value=\"\" name=\"s\" title=\"Search for:\" />\n" +
                "\t\t\t\t</label>\n" +
                "\t\t\t\t<input type=\"submit\" class=\"search-submit\" value=\"Search\" />\n" +
                "\t\t\t</form>\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</header><!-- #masthead -->\n" +
                "\n" +
                "\t<div id=\"main\" class=\"site-main\">\n" +
                "\n" +
                "<div id=\"main-content\" class=\"main-content\">\n" +
                "\n" +
                "\n" +
                "\t<div id=\"primary\" class=\"content-area\">\n" +
                "\t\t<div id=\"content\" class=\"site-content\" role=\"main\">\n" +
                "\n" +
                "\t\t\n" +
                "<article id=\"post-356\" class=\"post-356 post type-post status-publish format-standard hentry category-java\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=356\" rel=\"bookmark\">Примерно Контролно II по ПИК 3</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=356\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2016-01-03T06:12:43+00:00\">January 3, 2016</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=356#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<h1></h1>\n" +
                "<p>Да се моделира система(сървър) за обработка на документи за стипендии. Имате пълна свобода при решаване на конкретния проблем, с изключение на долупоставените минимални изисквания:<br />\n" +
                " <a href=\"http://javac.bg/?p=356#more-356\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Примерно Контролно II по ПИК 3</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t</article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-342\" class=\"post-342 post type-post status-publish format-standard hentry category-java tag-java tag-synchronized tag-thread\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=342\" rel=\"bookmark\">Синхронизация на нишки. Реализиране на многонишков сървър със синхронизирани методи.</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=342\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-12-13T14:53:59+00:00\">December 13, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=342#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">\n" +
                "В предишната статия разгледахме предимствата и недостатъците на многонишковото програмиране. Като един от основните недостатъци беше споменат проблемът, свързан със синхронизацията на отделните методи, които достъпват едновременно общи ресурси.<br />\n" +
                " <a href=\"http://javac.bg/?p=342#more-342\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Синхронизация на нишки. Реализиране на многонишков сървър със синхронизирани методи.</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=java\" rel=\"tag\">java</a><a href=\"http://javac.bg/?tag=synchronized\" rel=\"tag\">Synchronized</a><a href=\"http://javac.bg/?tag=thread\" rel=\"tag\">Thread</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-312\" class=\"post-312 post type-post status-publish format-standard hentry category-java tag-java tag-multithreading tag-threads\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=312\" rel=\"bookmark\">Нишки. Многонишково програмиране.</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=312\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-12-06T16:00:58+00:00\">December 6, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=312#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\"><strong><u>Многозадачност</u></strong><br />\n" +
                "Многозадачност като понятие в компютърните науки може да бъде разглеждано в два основни аспекта. Многозадачност, базирана на процеси и многозадачност, базирана на нишки.<br />\n" +
                " <a href=\"http://javac.bg/?p=312#more-312\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Нишки. Многонишково програмиране.</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=java\" rel=\"tag\">java</a><a href=\"http://javac.bg/?tag=multithreading\" rel=\"tag\">Multithreading</a><a href=\"http://javac.bg/?tag=threads\" rel=\"tag\">Threads</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-301\" class=\"post-301 post type-post status-publish format-standard hentry category-java tag-ip tag-network-programming tag-serversocket tag-socket tag-tcp\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=301\" rel=\"bookmark\">Основи на мрежовото програмиране. TCP сокети и IP  протоколи.</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=301\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-29T15:46:54+00:00\">November 29, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=301#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">През далечната 1962г. J.C.R. Licklider от университета MIT, за първи път в труда си &#8220;Galactic Network&#8221; развива идеята за създаване на единна глобална мрежа. Идеята бързо набира огромна популярност и през 1968г. в ARPANET (Advanced Research Projects Agency Network) е създадено първото мрежово устройство за комутация на пакети, наречено Interface Message Processors (IMP&#8217;s).<br />\n" +
                " <a href=\"http://javac.bg/?p=301#more-301\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Основи на мрежовото програмиране. TCP сокети и IP  протоколи.</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=ip\" rel=\"tag\">IP</a><a href=\"http://javac.bg/?tag=network-programming\" rel=\"tag\">Network programming</a><a href=\"http://javac.bg/?tag=serversocket\" rel=\"tag\">ServerSocket</a><a href=\"http://javac.bg/?tag=socket\" rel=\"tag\">Socket</a><a href=\"http://javac.bg/?tag=tcp\" rel=\"tag\">TCP</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-296\" class=\"post-296 post type-post status-publish format-standard hentry category-java tag-anonymous-classes tag-local tag-local-classes-nested-classes tag-nested tag-static\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=296\" rel=\"bookmark\">Статични и нестатични вложени член класове. Локални класове. Анонимни класове</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=296\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-29T11:05:15+00:00\">November 29, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=296#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">Често се случва, когато пишем класове, да осъзнаем, че ако комбинираме определени  член данни, то те съвсем спокойно могат да се обособят в отделен клас, който да репрезентира тези данни. Или пък по време на писане се сещаме, че ни трябва нов клас, който обаче е много здраво обвързан с вече съществуващ клас.  Друг сценарий е, когато ни трябва някакъв helper клас, който да спомага за работата на някой наш основен клас.  Езикът Java ни дава възможността да декларираме класове в рамките на даден клас.<br />\n" +
                " <a href=\"http://javac.bg/?p=296#more-296\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Статични и нестатични вложени член класове. Локални класове. Анонимни класове</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=anonymous-classes\" rel=\"tag\">anonymous classes</a><a href=\"http://javac.bg/?tag=local\" rel=\"tag\">local</a><a href=\"http://javac.bg/?tag=local-classes-nested-classes\" rel=\"tag\">local classes. nested classes</a><a href=\"http://javac.bg/?tag=nested\" rel=\"tag\">nested</a><a href=\"http://javac.bg/?tag=static\" rel=\"tag\">Static</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-261\" class=\"post-261 post type-post status-publish format-standard hentry category-java tag-data-structure tag-hashmap tag-java\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=261\" rel=\"bookmark\">How does HashMap work?</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=261\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-26T17:55:36+00:00\">November 26, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=261#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">Сигурно си спомняте за контракта между hashCode и equals :<br />\n" +
                "<em> 1.Ако два обекта са еднакви (equal), то те задължително трябва да имат едни и същи хеш кодове.</em><br />\n" +
                "<em> 2.Ако два обекта имат едни и същи хеш кодове, те могат, а могат и да не бъдат еднакви – това е в зависимост от устойчивостта на хеш функцията на колизии.</em>  <a href=\"http://javac.bg/?p=261#more-261\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">How does HashMap work?</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=data-structure\" rel=\"tag\">Data Structure</a><a href=\"http://javac.bg/?tag=hashmap\" rel=\"tag\">HashMap</a><a href=\"http://javac.bg/?tag=java\" rel=\"tag\">java</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-238\" class=\"post-238 post type-post status-publish format-standard hentry category-java tag-data-structures tag-hash-function tag-hashmap tag-hashtable tag-java\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=238\" rel=\"bookmark\">Хеш – функции и хеширане. Структури от данни, използващи хеш.</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=238\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-22T10:28:51+00:00\">November 22, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=238#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">Хеш функцията в математиката е такава функция, която служи за промяна на гъстотата на дадено множество – разширяване или стестняване на множеството. Казано по-друг начин, ако на входа на хеш функцията подаваме различни по дължина множества, на изхода ще получаваме низове, който ще бъде с фиксирана дължина и ще бъдат различни за различните множества на входа.  <a href=\"http://javac.bg/?p=238#more-238\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Хеш – функции и хеширане. Структури от данни, използващи хеш.</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=data-structures\" rel=\"tag\">Data structures</a><a href=\"http://javac.bg/?tag=hash-function\" rel=\"tag\">Hash function</a><a href=\"http://javac.bg/?tag=hashmap\" rel=\"tag\">HashMap</a><a href=\"http://javac.bg/?tag=hashtable\" rel=\"tag\">HashTable</a><a href=\"http://javac.bg/?tag=java\" rel=\"tag\">java</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-213\" class=\"post-213 post type-post status-publish format-standard hentry category-java tag-java-data-structures tag-16\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=213\" rel=\"bookmark\">ЛИНЕЙНИ СТРУКТУРИ ОТ ДАННИ</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=213\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-15T19:08:09+00:00\">November 15, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=213#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">В програмирането, както и в математиката, доста често се налага да обработваме дадено множество от елемети. Пример за това е прибавяне на елемент към дадено множество, премахване на елемент от множество, подреждане на множество по даден закон или даден показател. Структурите от данни са една основна концепция за съхранението и организацията на данните в компютърната наука.<br />\n" +
                " <a href=\"http://javac.bg/?p=213#more-213\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">ЛИНЕЙНИ СТРУКТУРИ ОТ ДАННИ</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=java-data-structures\" rel=\"tag\">java data structures</a><a href=\"http://javac.bg/?tag=%d1%81%d1%82%d1%80%d1%83%d0%ba%d1%82%d1%83%d1%80%d0%b8-%d0%be%d1%82-%d0%b4%d0%b0%d0%bd%d0%bd%d0%b8\" rel=\"tag\">структури от данни</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-202\" class=\"post-202 post type-post status-publish format-standard hentry category-java tag-java-code\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=202\" rel=\"bookmark\">Решение на задача от контролно 14.11.2015</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=202\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-14T17:33:55+00:00\">November 14, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=202#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p>Имате за задача да релизирате back end компонент от уеб система за резервация на билети за събития. Всеки ден във файл постъпват наличните билети за нови концерти. Системата зарежда билетите и „отваря врати” за покупко-продажбата, файлът се трие и се зарежда отново на другия ден. Клиенти се свързват през уеб базиран интерфейс към системата и си резервират билети.<br />\n" +
                " <a href=\"http://javac.bg/?p=202#more-202\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Решение на задача от контролно 14.11.2015</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=java-code\" rel=\"tag\">java code</a></span></footer></article><!-- #post-## -->\n" +
                "\n" +
                "<article id=\"post-179\" class=\"post-179 post type-post status-publish format-standard hentry category-java tag-file\">\n" +
                "\t\n" +
                "\t<header class=\"entry-header\">\n" +
                "\t\t<h1 class=\"entry-title\"><a href=\"http://javac.bg/?p=179\" rel=\"bookmark\">Работа с файлове. Четене и писане. Обработка и употреба на файлове.</a></h1>\n" +
                "\t\t<div class=\"entry-meta\">\n" +
                "\t\t\t<span class=\"entry-date\"><a href=\"http://javac.bg/?p=179\" rel=\"bookmark\"><time class=\"entry-date\" datetime=\"2015-11-08T15:29:01+00:00\">November 8, 2015</time></a></span> <span class=\"byline\"><span class=\"author vcard\"><a class=\"url fn n\" href=\"http://javac.bg/?author=1\" rel=\"author\">Явор Томов</a></span></span>\t\t\t<span class=\"comments-link\"><a href=\"http://javac.bg/?p=179#respond\">Leave a comment</a></span>\n" +
                "\t\t\t\t\t</div><!-- .entry-meta -->\n" +
                "\t</header><!-- .entry-header -->\n" +
                "\n" +
                "\t\t<div class=\"entry-content\">\n" +
                "\t\t<p style=\"text-align: left;\">Всички операции, които са свързани с достъпване на ресурси извън програмата, се наричат входно-изходни операции(I/O Operations). Освен четене от клавиатура, писане в конзола и тн, четене/писане във файл също е такава операция.<br />\n" +
                " <a href=\"http://javac.bg/?p=179#more-179\" class=\"more-link\">Continue reading <span class=\"screen-reader-text\">Работа с файлове. Четене и писане. Обработка и употреба на файлове.</span> <span class=\"meta-nav\">&rarr;</span></a></p>\n" +
                "\t</div><!-- .entry-content -->\n" +
                "\t\n" +
                "\t<footer class=\"entry-meta\"><span class=\"tag-links\"><a href=\"http://javac.bg/?tag=file\" rel=\"tag\">file</a></span></footer></article><!-- #post-## -->\n" +
                "\t<nav class=\"navigation paging-navigation\" role=\"navigation\">\n" +
                "\t\t<h1 class=\"screen-reader-text\">Posts navigation</h1>\n" +
                "\t\t<div class=\"pagination loop-pagination\">\n" +
                "\t\t\t<span class='page-numbers current'>1</span>\n" +
                "<a class='page-numbers' href='http://javac.bg/?paged=2'>2</a>\n" +
                "<a class=\"next page-numbers\" href=\"http://javac.bg/?paged=2\">Next &rarr;</a>\t\t</div><!-- .pagination -->\n" +
                "\t</nav><!-- .navigation -->\n" +
                "\t\n" +
                "\t\t</div><!-- #content -->\n" +
                "\t</div><!-- #primary -->\n" +
                "\t</div><!-- #main-content -->\n" +
                "\n" +
                "<div id=\"secondary\">\n" +
                "\t\t<h2 class=\"site-description\">Блогът на Явор Томов</h2>\n" +
                "\t\n" +
                "\t\n" +
                "\t\t<div id=\"primary-sidebar\" class=\"primary-sidebar widget-area\" role=\"complementary\">\n" +
                "\t\t<aside id=\"search-2\" class=\"widget widget_search\"><form role=\"search\" method=\"get\" class=\"search-form\" action=\"http://javac.bg/\">\n" +
                "\t\t\t\t<label>\n" +
                "\t\t\t\t\t<span class=\"screen-reader-text\">Search for:</span>\n" +
                "\t\t\t\t\t<input type=\"search\" class=\"search-field\" placeholder=\"Search &hellip;\" value=\"\" name=\"s\" title=\"Search for:\" />\n" +
                "\t\t\t\t</label>\n" +
                "\t\t\t\t<input type=\"submit\" class=\"search-submit\" value=\"Search\" />\n" +
                "\t\t\t</form></aside>\t\t<aside id=\"recent-posts-2\" class=\"widget widget_recent_entries\">\t\t<h1 class=\"widget-title\">Recent Posts</h1>\t\t<ul>\n" +
                "\t\t\t\t\t<li>\n" +
                "\t\t\t\t<a href=\"http://javac.bg/?p=356\">Примерно Контролно II по ПИК 3</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li>\n" +
                "\t\t\t\t<a href=\"http://javac.bg/?p=342\">Синхронизация на нишки. Реализиране на многонишков сървър със синхронизирани методи.</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li>\n" +
                "\t\t\t\t<a href=\"http://javac.bg/?p=312\">Нишки. Многонишково програмиране.</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li>\n" +
                "\t\t\t\t<a href=\"http://javac.bg/?p=301\">Основи на мрежовото програмиране. TCP сокети и IP  протоколи.</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li>\n" +
                "\t\t\t\t<a href=\"http://javac.bg/?p=296\">Статични и нестатични вложени член класове. Локални класове. Анонимни класове</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t</aside><aside id=\"categories-2\" class=\"widget widget_categories\"><h1 class=\"widget-title\">Categories</h1>\t\t<ul>\n" +
                "\t<li class=\"cat-item cat-item-3\"><a href=\"http://javac.bg/?cat=3\" title=\"Java course\">Java</a>\n" +
                "</li>\n" +
                "\t\t</ul>\n" +
                "</aside>\t</div><!-- #primary-sidebar -->\n" +
                "\t</div><!-- #secondary -->\n" +
                "\n" +
                "\t\t</div><!-- #main -->\n" +
                "\n" +
                "\t\t<footer id=\"colophon\" class=\"site-footer\" role=\"contentinfo\">\n" +
                "\n" +
                "\t\t\t\n" +
                "\t\t\t<div class=\"site-info\">\n" +
                "\t\t\t\t\t\t\t\t<a href=\"https://wordpress.org/\">Proudly powered by WordPress</a>\n" +
                "\t\t\t</div><!-- .site-info -->\n" +
                "\t\t</footer><!-- #colophon -->\n" +
                "\t</div><!-- #page -->\n" +
                "\n" +
                "\t<script type='text/javascript' src='http://javac.bg/wp-content/themes/twentyfourteen/js/functions.js?ver=20150315'></script>\n" +
                "<script>\n" +
                "jQuery( document ).ready( function($) {\n" +
                "\t$('.bawpvc-ajax-counter').each( function( i ) {\n" +
                "\t\tvar $id = $(this).data('id');\n" +
                "\t\tvar t = this;\n" +
                "\t\tvar n = 0;\n" +
                "\t\t$.get('http://javac.bg/wp-admin/admin-ajax.php?action=bawpvc-ajax-counter&p='+$id+'&n='+n, function( html ) {\n" +
                "\t\t\t$(t).html( html );\n" +
                "\t\t})\n" +
                "\t});\n" +
                "});\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
        HashSet<String> set = a.getAllLinks(q);
        Iterator<String> g = set.iterator();
        while (g.hasNext()) {
            System.out.println(g.next().toString());
        }
    }
    

}