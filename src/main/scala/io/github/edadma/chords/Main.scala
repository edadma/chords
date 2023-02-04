package io.github.edadma.chords

import math._

import io.github.edadma.libcairo._

@main def run(): Unit =
  val surface = pdfSurfaceCreate("test.pdf", 612, 792)
  val cr = surface.create

  cr.setSourceRGB(0.0, 0.0, 0.0)
  cr.selectFontFace("Georgia", FontSlant.NORMAL, FontWeight.BOLD)

  cr.setLineWidth(1)

  for x <- 0 to 612 by 72 do
    cr.moveTo(x, 0)
    cr.relLineTo(0, 100)

  cr.stroke()

  cr.destroy()
  surface.destroy()
