<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui">

    <title>Zooplus Challenge - The solution</title>
    <meta name="description" content="My solution to Zooplus challenge">
    <meta name="author" content="José Moreno (github.com/jomoespe)">

    <link rel="stylesheet" href="script/reveal.js/css/reveal.css">
    <link rel="stylesheet" href="script/reveal.js/css/theme/sky.css" id="theme">
    <!-- Code syntax highlighting -->
    <link rel="stylesheet" href="script/reveal.js/lib/css/zenburn.css">
    <!-- Printing and PDF exports -->
    <script>
      var link = document.createElement( 'link' );
      link.rel = 'stylesheet';
      link.type = 'text/css';
      link.href = window.location.search.match( /print-pdf/gi ) ? 'script/reveal.js/css/print/pdf.css' : 'script/reveal.js/css/print/paper.css';
      document.getElementsByTagName( 'head' )[0].appendChild( link );
    </script>
    <!--[if lt IE 9]>
    <script src="lib/js/html5shiv.js"></script>
    <![endif]-->
    <style>
      .reveal a img { background:none; border:none; box-shadow:none; }
      .reveal table.stickers img { background:none; border:none; box-shadow:none; width:120px; height: auto; }
      .reveal table.stickers td { background:none; border:none; box-shadow:none; }
    </style>
  </head>

  <body>
    <div class="reveal">
      <!-- Any section element inside of this container is displayed as a slide -->
      <div class="slides">
        <!-- Cover 
             -->
        <section>
          <!--h1>Zooplus Challenge</h1-->
          <h2>My solution to XXX</h2>
          <h3>Coming soon...</h3>
        </section> <!-- End cover -->
<%--
        <!-- Description 
             -->
        <section>
          <!-- Textual -->
          <section>
            <p>This project is my response to <!--the Zooplus Challenge.--></p>
            <p>You can see <a href="https://github.com/jomoespe/zooplus-challenge" target="_new">the code on GitHub</a> <a href="https://travis-ci.org/jomoespe/zooplus-challenge" target="_new"><img src="https://travis-ci.org/jomoespe/zooplus-challenge.svg?branch=master"></a></p>
            <!-- TODO Complete the description  -->
              <h2>Principles</h2>
              <ul>
                <li>What is Ansible</li>
                <li>Why use Ansible</li>
                <li>Components
                  <ul>
                    <li>Inventory</li>
                    <li>Playbooks</li>
                    <li>Roles</li>
                  </ul>
                </li>
                <li>Demo</li>
              </ul>
              <p><small>(*) A page with a list</small></p>
          </section> <!-- End textual -->

          <!-- Stickers -->
          <section class="stickers">
            <!-- TODO See how to change images size and position, and remove border -->
            <h1>The stickers</h1>
            <table class="stickers">
              <tr>
                <td><img src="images/stickers/duke.png"    alt="Java 8"        class="sticker"></td>
                <td><img src="images/stickers/github.png"  alt="GitHub"        class="sticker"></td>
                <td><img src="images/stickers/h2.png"      alt="H2 database"   class="sticker"></td>
              </tr>
              <tr>
                <td><img src="images/stickers/spring.png"  alt="Spring Boot"   class="sticker"></td>
                <td><img src="images/stickers/purecss.png" alt="PureCSS"       class="sticker"></td>
                <td><img src="images/stickers/travis.png"  alt="Travic-CI"     class="sticker"></td>
              </tr>
              <tr>
                <td><img src="images/stickers/docker.png"  alt="Docker"        class="sticker"></td>
                <td><img src="images/stickers/do.png"      alt="Digital Ocean" class="sticker"></td>
                <td></td>
              </tr>
            </table>
          </section> <!-- End stickers -->
        </section> <!-- End descrioption -->
--%>
      </div>
    </div>

    <script src="script/reveal.js/lib/js/head.min.js"></script>
    <script src="script/reveal.js/js/reveal.js"></script>
    <script>
      // Full list of configuration options available at:
      // https://github.com/hakimel/reveal.js#configuration
      Reveal.initialize({
        controls: true,
        progress: true,
        history: true,
        center: true,
        transition: 'slide', // none/fade/slide/convex/concave/zoom
        // Optional reveal.js plugins
        dependencies: [
          { src: 'script/reveal.js/lib/js/classList.js', condition: function() { return !document.body.classList; } },
          { src: 'script/reveal.js/plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
          { src: 'script/reveal.js/plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
          { src: 'script/reveal.js/plugin/highlight/highlight.js', async: true, condition: function() { return !!document.querySelector( 'pre code' ); }, callback: function() { hljs.initHighlightingOnLoad(); } },
          { src: 'script/reveal.js/plugin/zoom-js/zoom.js', async: true },
          { src: 'script/reveal.js/plugin/notes/notes.js', async: true }
        ]
      });
    </script>
  </body>
</html>
