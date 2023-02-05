package io.github.edadma.chords

import math._

import io.github.edadma.libcairo._

@main def run(): Unit =
  val surface = pdfSurfaceCreate("test.pdf", 612, 792)
  val cr = surface.create

  cr.setSourceRGB(0.0, 0.0, 0.0)
  cr.selectFontFace("zxcv", FontSlant.NORMAL, FontWeight.BOLD)

  cr.translate(36, 36)

  cr.moveTo(0, 0)
  cr.setLineWidth(.5)
  cr.relLineTo(100, 0)
  cr.stroke()

  val fe = cr.fontExtents
  val text = "12 point text"

  cr.setFontSize(12)

  val te = cr.textExtents(text)

  val x = 0
  val y = -te.yBearing

  cr.moveTo(x, y)
  cr.showText(text)
  cr.moveTo(x, y + fe.height)
  cr.showText(text)

  cr.rectangle(x + te.xBearing, y + te.yBearing, te.width, te.height)
  cr.stroke()

  cr.moveTo(0, 0)

  for x <- 0 to 612 by 72 do
    cr.moveTo(x, 0)
    cr.relLineTo(0, 100)

  cr.stroke()

  cr.destroy()
  surface.destroy()
