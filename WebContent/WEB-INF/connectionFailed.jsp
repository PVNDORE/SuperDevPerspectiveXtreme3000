<!-- Note, this may have some issues in Firefox at present -->

<!-- This is not entirely my original work. The matrix code is from a demo I dug up about a year and a half ago, which seemed like it might find a better home on CodePen.io -->

<!-- Credit for original HTML5/JS programming of the Matrix code: http://www.scirra.com/forum/matrix-raining-code_topic51315.html -->
<link rel="stylesheet" type="text/css" media="screen" href="inc/css/connectionFailed.css" />
<div id="message">
  <h1>A glitch has occured [code: LOGIN-FAILURE]</h1>
  <p>
    <b>Boy</b>: Do not try and bend the website. That&#039;s impossible. Instead... only try to realize the truth. 
    <br />
    <b>Neo</b>: What truth? 
    <br />
    <b>Boy</b>: There is no page. 
    <br />
    <b>Neo</b>: There is no page? 
    <br />
    <b>Boy</b>: Then you&#039;ll see, that it is not the website that bends, it is only yourself.
  </p>
</div>	

<!-- The canvas must be inside a div called c2canvasdiv -->
<div id="c2canvasdiv">

  <!-- The canvas the project will render to.  If you change its ID, don't forget to change the
  ID the runtime looks for in the jQuery events above (ready() and cr_sizeCanvas()). -->
  <canvas id="c2canvas" width="960" height="640">
    <!-- This text is displayed if the visitor's browser does not support HTML5.
   You can change it, but it is a good idea to link to a description of a browser
   and provide some links to download some popular HTML5-compatible browsers. -->
    <h3>Your browser does not appear to support HTML5.  Try upgrading your browser to the latest version.  <a href="http://www.whatbrowser.org">What is a browser?</a>
      <br/><br/><a href="https://www.microsoft.com/windows/internet-explorer/default.aspx">Microsoft Internet Explorer</a><br/>
      <a href="http://www.mozilla.com/firefox/">Mozilla Firefox</a><br/>
      <a href="https://www.google.com/chrome/">Google Chrome</a><br/>
      <a href="https://www.apple.com/safari/download/">Apple Safari</a><br/>
      <a href="https://www.google.com/chromeframe">Google Chrome Frame for Internet Explorer</a><br/></h3>
  </canvas>

</div>
<script src="inc/js/connectionFailed.js"></script>