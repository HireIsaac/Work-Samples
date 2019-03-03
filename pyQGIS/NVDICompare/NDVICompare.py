#Purpose: Python scripts to create comparison and color rasters
#Author: Isaac Lohnes
#Date: Revised on 2/18/2019

#Imports: 
from PyQt4 import QtGui
import processing
from qgis.analysis import QgsRasterCalculator, QgsRasterCalculatorEntry

#Setup input and output for comparison calc
julyLayer = processing.getObjectFromName('NDVI_Jul_4_18')
augustLayer = processing.getObjectFromName('NDVI_Aug_31_18')
output = "C:\schoolRepos\w0409360\GIS\NVDICompare\NDVI Rasters\NDVI Rasters\NDVI_Compare.tif"

#setting up new calc entry with reference, raster set to file, and band number set to 1
julyRaster = QgsRasterCalculatorEntry()
julyRaster.ref = "July@1"
julyRaster.raster = julyLayer
julyRaster.bandNumber = 1

#setting up new calc entry with reference, raster set to file, and band number set to 1
augustRaster = QgsRasterCalculatorEntry()
augustRaster.ref = "Aug@1"
augustRaster.raster = augustLayer
augustRaster.bandNumber = 1

#Creating list of rasters to use in calc
rasterList = [julyRaster, augustRaster]

#Formula finds difference in references
formula = ('Aug@1 - July@1')

#Setting up calculator with arguments, and processing
calc = QgsRasterCalculator(formula, output, "GTiff", augustLayer.extent(), augustLayer.width(), augustLayer.height(), rasterList)
calc.processCalculation()

#Output to file 
output = iface.addRasterLayer(output, "NDVI_Compare")

#Begin creation of color ramp using output from raster cal
layer = QgsRasterLayer("C:\schoolRepos\w0409360\GIS\NVDICompare\NDVI Rasters\NDVI Rasters\NDVI_Compare.tif", "DEM")
s = QgsRasterShader()
c = QgsColorRampShader()
c.setColorRampType(QgsColorRampShader.INTERPOLATED)

#create list of color ramp items
i = []
i.append(QgsColorRampShader.ColorRampItem(-.253717, QtGui.QColor('#d7191c'), '-.25'))
i.append(QgsColorRampShader.ColorRampItem(-.04, QtGui.QColor('#fdae61'), '-04'))
i.append(QgsColorRampShader.ColorRampItem(.17, QtGui.QColor('#ffffbf'), '.17'))
i.append(QgsColorRampShader.ColorRampItem(.38, QtGui.QColor('#abdda4'), '0.38'))
i.append(QgsColorRampShader.ColorRampItem(.589682, QtGui.QColor('#2b83ba'), '.59'))

#Add layer to map 
c.setColorRampItemList(i)
s.setRasterShaderFunction(c)
ps = QgsSingleBandPseudoColorRenderer(layer.dataProvider(), 1, s)
layer.setRenderer(ps)
QgsMapLayerRegistry.instance().addMapLayer(layer)