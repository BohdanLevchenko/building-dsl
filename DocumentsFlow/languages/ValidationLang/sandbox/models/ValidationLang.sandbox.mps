<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:a7c6fabd-283d-402e-9d4b-09354bd1e7b2(ValidationLang.sandbox)">
  <persistence version="9" />
  <languages>
    <use id="e6eb9059-4b44-4f40-a7a0-04b2d2ca42db" name="ValidationLang" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="e6eb9059-4b44-4f40-a7a0-04b2d2ca42db" name="ValidationLang">
      <concept id="7422067737622263032" name="ValidationLang.structure.Inspection" flags="ng" index="3KRcYK">
        <property id="7422067737622263033" name="name" index="3KRcYL" />
        <property id="7422067737622263035" name="expression" index="3KRcYN" />
      </concept>
      <concept id="7422067737622263029" name="ValidationLang.structure.Inspections" flags="ng" index="3KRcYX">
        <child id="7422067737622320951" name="inspection" index="3KRuLZ" />
      </concept>
    </language>
  </registry>
  <node concept="3KRcYX" id="6s0uOynRp_p">
    <node concept="3KRcYK" id="6s0uOynRp_q" role="3KRuLZ">
      <property role="3KRcYL" value="&quot;Title is reqired&quot;" />
      <property role="3KRcYN" value="title.empty" />
    </node>
  </node>
</model>

