package com.github.andriell;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void setStyle() {
        // 	AATextInfoPropertyKey	sun.swing.SwingUtilities2$AATextInfo@442d9b6e
        // 	activeCaption	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	activeCaptionBorder	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	activeCaptionText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	AuditoryCues.allAuditoryCues	[Ljava.lang.Object;@1698c449
        // 	AuditoryCues.cueList	[Ljava.lang.Object;@1698c449
        // 	AuditoryCues.defaultCueList	[Ljava.lang.Object;@1c655221
        // 	AuditoryCues.noAuditoryCues	[Ljava.lang.Object;@1a93a7ca
        // 	Button.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Button.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@77468bd9
        // 	Button.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	Button.defaultButtonFollowsFocus	false
        // 	Button.disabledText	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	Button.disabledToolBarBorderBackground	javax.swing.plaf.ColorUIResource[r=204,g=204,b=204]
        // 	Button.focus	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	Button.focusInputMap	javax.swing.plaf.InputMapUIResource@606d8acf
        // 	Button.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	Button.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Button.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	Button.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Button.light	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Button.margin	javax.swing.plaf.InsetsUIResource[top=2,left=14,bottom=2,right=14]
        // 	Button.rollover	true
        // 	Button.rolloverIconType	ocean
        // 	Button.select	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Button.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Button.textIconGap	4
        // 	Button.textShiftOffset	0
        // 	Button.toolBarBorderBackground	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	ButtonUI	javax.swing.plaf.metal.MetalButtonUI
        // 	CheckBox.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	CheckBox.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@27ddd392
        // 	CheckBox.disabledText	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	CheckBox.focus	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	CheckBox.focusInputMap	javax.swing.plaf.InputMapUIResource@38cccef
        // 	CheckBox.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	CheckBox.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	CheckBox.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	CheckBox.icon	javax.swing.plaf.metal.MetalIconFactory$CheckBoxIcon@76ccd017
        // 	CheckBox.margin	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2]
        // 	CheckBox.rollover	true
        // 	Checkbox.select	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	CheckBox.textIconGap	4
        // 	CheckBox.textShiftOffset	0
        // 	CheckBox.totalInsets	java.awt.Insets[top=4,left=4,bottom=4,right=4]
        // 	CheckBoxMenuItem.acceleratorFont	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=10]
        // 	CheckBoxMenuItem.acceleratorForeground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	CheckBoxMenuItem.acceleratorSelectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	CheckBoxMenuItem.arrowIcon	javax.swing.plaf.metal.MetalIconFactory$MenuItemArrowIcon@5e91993f
        // 	CheckBoxMenuItem.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	CheckBoxMenuItem.border	javax.swing.plaf.metal.MetalBorders$MenuItemBorder@12bb4df8
        // 	CheckBoxMenuItem.borderPainted	true
        // 	CheckBoxMenuItem.checkIcon	javax.swing.plaf.metal.MetalIconFactory$CheckBoxMenuItemIcon@5f8ed237
        // 	CheckBoxMenuItem.commandSound	sounds/MenuItemCommand.wav
        // 	CheckBoxMenuItem.disabledForeground	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	CheckBoxMenuItem.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	CheckBoxMenuItem.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	CheckBoxMenuItem.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	CheckBoxMenuItem.margin	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2]
        // 	CheckBoxMenuItem.selectionBackground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	CheckBoxMenuItem.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	CheckBoxMenuItemUI	javax.swing.plaf.basic.BasicCheckBoxMenuItemUI
        // 	CheckBoxUI	javax.swing.plaf.metal.MetalCheckBoxUI
        // 	ColorChooser.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ColorChooser.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	ColorChooser.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ColorChooser.swatchesDefaultRecentColor	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ColorChooser.swatchesRecentSwatchSize	java.awt.Dimension[width=10,height=10]
        // 	ColorChooser.swatchesSwatchSize	java.awt.Dimension[width=10,height=10]
        // 	ColorChooserUI	javax.swing.plaf.basic.BasicColorChooserUI

        // 	ComboBox.ancestorInputMap	javax.swing.plaf.InputMapUIResource@36aa7bc2
        // 	ComboBox.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ComboBox.buttonBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ComboBox.buttonDarkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ComboBox.buttonHighlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ComboBox.buttonShadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ComboBox.disabledBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ComboBox.disabledForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ComboBox.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	ComboBox.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ComboBox.isEnterSelectablePopup	false
        // 	ComboBox.noActionOnKeyNavigation	false
        // 	ComboBox.selectionBackground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	ComboBox.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ComboBox.timeFactor	1000
        // 	ComboBoxUI	javax.swing.plaf.metal.MetalComboBoxUI

        // 	control	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	controlDkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	controlHighlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	controlLtHighlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	controlShadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	controlText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	desktop	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Desktop.ancestorInputMap	javax.swing.plaf.InputMapUIResource@5ccd43c2
        // 	Desktop.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Desktop.minOnScreenInsets	javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3]
        // 	DesktopIcon.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	DesktopIcon.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@2f410acf
        // 	DesktopIcon.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	DesktopIcon.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	DesktopIcon.width	160
        // 	DesktopIconUI	javax.swing.plaf.metal.MetalDesktopIconUI
        // 	DesktopPaneUI	javax.swing.plaf.basic.BasicDesktopPaneUI
        // 	EditorPane.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	EditorPane.border	javax.swing.plaf.basic.BasicBorders$MarginBorder@71bc1ae4
        // 	EditorPane.caretBlinkRate	500
        // 	EditorPane.caretForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	EditorPane.focusInputMap	javax.swing.plaf.InputMapUIResource@68fb2c38
        // 	EditorPane.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	EditorPane.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	EditorPane.inactiveForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	EditorPane.margin	javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3]
        // 	EditorPane.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	EditorPane.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	EditorPaneUI	javax.swing.plaf.basic.BasicEditorPaneUI
        // 	FileChooser.ancestorInputMap	javax.swing.plaf.InputMapUIResource@4aa8f0b4
        // 	FileChooser.detailsViewIcon	javax.swing.plaf.metal.MetalIconFactory$FileChooserDetailViewIcon@4361bd48
        // 	FileChooser.homeFolderIcon	sun.swing.ImageIconUIResource@244038d0
        // 	FileChooser.listViewIcon	javax.swing.plaf.metal.MetalIconFactory$FileChooserListViewIcon@1c4af82c
        // 	FileChooser.newFolderIcon	sun.swing.ImageIconUIResource@3a4afd8d
        // 	FileChooser.readOnly	false
        // 	FileChooser.upFolderIcon	sun.swing.ImageIconUIResource@2aae9190
        // 	FileChooser.usesSingleFilePane	true
        // 	FileChooser.useSystemExtensionHiding	false
        // 	FileChooserUI	javax.swing.plaf.metal.MetalFileChooserUI
        // 	FileView.computerIcon	sun.swing.ImageIconUIResource@3419866c
        // 	FileView.directoryIcon	sun.swing.ImageIconUIResource@2ff5659e
        // 	FileView.fileIcon	sun.swing.ImageIconUIResource@59f95c5d
        // 	FileView.floppyDriveIcon	sun.swing.ImageIconUIResource@6a6824be
        // 	FileView.hardDriveIcon	sun.swing.ImageIconUIResource@7a46a697
        // 	FormattedTextField.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	FormattedTextField.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@69222c14
        // 	FormattedTextField.caretBlinkRate	500
        // 	FormattedTextField.caretForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	FormattedTextField.focusInputMap	javax.swing.plaf.InputMapUIResource@6d1e7682
        // 	FormattedTextField.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	FormattedTextField.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	FormattedTextField.inactiveBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	FormattedTextField.inactiveForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	FormattedTextField.margin	javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0]
        // 	FormattedTextField.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	FormattedTextField.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	FormattedTextFieldUI	javax.swing.plaf.basic.BasicFormattedTextFieldUI
        // 	html.missingImage	sun.swing.ImageIconUIResource@3b22cdd0
        // 	html.pendingImage	sun.swing.ImageIconUIResource@7a7b0070
        // 	inactiveCaption	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	inactiveCaptionBorder	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	inactiveCaptionText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	info	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	infoText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	InternalFrame.activeTitleBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	InternalFrame.activeTitleForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	InternalFrame.activeTitleGradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	InternalFrame.border	javax.swing.plaf.metal.MetalBorders$InternalFrameBorder@3ada9e37
        // 	InternalFrame.borderColor	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	InternalFrame.borderDarkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	InternalFrame.borderHighlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	InternalFrame.borderLight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	InternalFrame.borderShadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	InternalFrame.closeIcon	javax.swing.plaf.metal.OceanTheme$IFIcon@9e89d68
        // 	InternalFrame.closeSound	sounds/FrameClose.wav
        // 	InternalFrame.icon	sun.swing.ImageIconUIResource@6d86b085
        // 	InternalFrame.iconifyIcon	javax.swing.plaf.metal.OceanTheme$IFIcon@6842775d
        // 	InternalFrame.inactiveTitleBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	InternalFrame.inactiveTitleForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	InternalFrame.maximizeIcon	javax.swing.plaf.metal.OceanTheme$IFIcon@16b3fc9e
        // 	InternalFrame.maximizeSound	sounds/FrameMaximize.wav
        // 	InternalFrame.minimizeIcon	javax.swing.plaf.metal.OceanTheme$IFIcon@16b4a017
        // 	InternalFrame.minimizeSound	sounds/FrameMinimize.wav
        // 	InternalFrame.optionDialogBorder	javax.swing.plaf.metal.MetalBorders$OptionDialogBorder@11028347
        // 	InternalFrame.paletteBorder	javax.swing.plaf.metal.MetalBorders$PaletteBorder@ee7d9f1
        // 	InternalFrame.paletteCloseIcon	javax.swing.plaf.metal.OceanTheme$IFIcon@6d9c638
        // 	InternalFrame.paletteTitleHeight	11
        // 	InternalFrame.restoreDownSound	sounds/FrameRestoreDown.wav
        // 	InternalFrame.restoreUpSound	sounds/FrameRestoreUp.wav
        // 	InternalFrame.titleFont	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	InternalFrameTitlePane.closeButtonOpacity	true
        // 	InternalFrameTitlePane.iconifyButtonOpacity	true
        // 	InternalFrameTitlePane.maximizeButtonOpacity	true
        // 	InternalFrameUI	javax.swing.plaf.metal.MetalInternalFrameUI
        // 	Label.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Label.disabledForeground	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	Label.disabledShadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Label.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	Label.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	LabelUI	javax.swing.plaf.metal.MetalLabelUI
        // 	List.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	List.cellRenderer	javax.swing.DefaultListCellRenderer$UIResource[List.cellRenderer,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.EmptyBorder@6073f712,flags=25165832,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,horizontalAlignment=LEADING,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER]
        // 	List.dropCellBackground	javax.swing.plaf.ColorUIResource[r=210,g=233,b=255]
        // 	List.dropLineColor	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	List.focusCellHighlightBorder	javax.swing.plaf.BorderUIResource$LineBorderUIResource@782830e
        // 	List.focusInputMap	javax.swing.plaf.InputMapUIResource@3b192d32
        // 	List.focusInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@1f89ab83
        // 	List.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	List.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	List.noFocusBorder	javax.swing.plaf.BorderUIResource$EmptyBorderUIResource@61e717c2
        // 	List.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	List.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	List.timeFactor	1000
        // 	ListUI	javax.swing.plaf.basic.BasicListUI
        // 	menu	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Menu.acceleratorFont	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=10]
        // 	Menu.acceleratorForeground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	Menu.acceleratorSelectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Menu.arrowIcon	javax.swing.plaf.metal.MetalIconFactory$MenuArrowIcon@26f0a63f
        // 	Menu.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Menu.border	javax.swing.plaf.metal.MetalBorders$MenuItemBorder@1055e4af
        // 	Menu.borderPainted	true
        // 	Menu.cancelMode	hideLastSubmenu
        // 	Menu.checkIcon	null
        // 	Menu.crossMenuMnemonic	true
        // 	Menu.disabledForeground	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	Menu.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	Menu.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Menu.margin	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2]
        // 	Menu.menuPopupOffsetX	0
        // 	Menu.menuPopupOffsetY	0
        // 	Menu.opaque	false
        // 	Menu.preserveTopLevelSelection	false
        // 	Menu.selectionBackground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	Menu.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Menu.shortcutKeys	[I@4e515669
        // 	Menu.submenuPopupOffsetX	-4
        // 	Menu.submenuPopupOffsetY	-3
        // 	MenuBar.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	MenuBar.border	javax.swing.plaf.metal.MetalBorders$MenuBarBorder@4d591d15
        // 	MenuBar.borderColor	javax.swing.plaf.ColorUIResource[r=204,g=204,b=204]
        // 	MenuBar.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	MenuBar.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	MenuBar.gradient	[1.0, 0.0, javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=218,g=218,b=218], javax.swing.plaf.ColorUIResource[r=218,g=218,b=218]]
        // 	MenuBar.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	MenuBar.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	MenuBar.windowBindings	[Ljava.lang.Object;@58d25a40
        // 	MenuBarUI	javax.swing.plaf.metal.MetalMenuBarUI
        // 	MenuItem.acceleratorDelimiter	-0
        // 	MenuItem.acceleratorFont	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=10]
        // 	MenuItem.acceleratorForeground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	MenuItem.acceleratorSelectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	MenuItem.arrowIcon	javax.swing.plaf.metal.MetalIconFactory$MenuItemArrowIcon@5e91993f
        // 	MenuItem.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	MenuItem.border	javax.swing.plaf.metal.MetalBorders$MenuItemBorder@7d6f77cc
        // 	MenuItem.borderPainted	true
        // 	MenuItem.checkIcon	null
        // 	MenuItem.commandSound	sounds/MenuItemCommand.wav
        // 	MenuItem.disabledForeground	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	MenuItem.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	MenuItem.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	MenuItem.margin	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2]
        // 	MenuItem.selectionBackground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	MenuItem.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	MenuItemUI	javax.swing.plaf.basic.BasicMenuItemUI
        // 	menuText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	MenuUI	javax.swing.plaf.basic.BasicMenuUI
        // 	OptionPane.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	OptionPane.border	javax.swing.plaf.BorderUIResource$EmptyBorderUIResource@39ed3c8d
        // 	OptionPane.buttonAreaBorder	javax.swing.plaf.BorderUIResource$EmptyBorderUIResource@41a4555e
        // 	OptionPane.buttonClickThreshhold	500
        // 	OptionPane.errorDialog.border.background	javax.swing.plaf.ColorUIResource[r=153,g=51,b=51]
        // 	OptionPane.errorDialog.titlePane.background	javax.swing.plaf.ColorUIResource[r=255,g=153,b=153]
        // 	OptionPane.errorDialog.titlePane.foreground	javax.swing.plaf.ColorUIResource[r=51,g=0,b=0]
        // 	OptionPane.errorDialog.titlePane.shadow	javax.swing.plaf.ColorUIResource[r=204,g=102,b=102]
        // 	OptionPane.errorIcon	sun.swing.ImageIconUIResource@7b1d7fff
        // 	OptionPane.errorSound	sounds/OptionPaneError.wav
        // 	OptionPane.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	OptionPane.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	OptionPane.informationIcon	sun.swing.ImageIconUIResource@383534aa
        // 	OptionPane.informationSound	sounds/OptionPaneInformation.wav
        // 	OptionPane.messageAreaBorder	javax.swing.plaf.BorderUIResource$EmptyBorderUIResource@5680a178
        // 	OptionPane.messageForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	OptionPane.minimumSize	javax.swing.plaf.DimensionUIResource[width=262,height=90]
        // 	OptionPane.questionDialog.border.background	javax.swing.plaf.ColorUIResource[r=51,g=102,b=51]
        // 	OptionPane.questionDialog.titlePane.background	javax.swing.plaf.ColorUIResource[r=153,g=204,b=153]
        // 	OptionPane.questionDialog.titlePane.foreground	javax.swing.plaf.ColorUIResource[r=0,g=51,b=0]
        // 	OptionPane.questionDialog.titlePane.shadow	javax.swing.plaf.ColorUIResource[r=102,g=153,b=102]
        // 	OptionPane.questionIcon	sun.swing.ImageIconUIResource@ed17bee
        // 	OptionPane.questionSound	sounds/OptionPaneQuestion.wav
        // 	OptionPane.warningDialog.border.background	javax.swing.plaf.ColorUIResource[r=153,g=102,b=51]
        // 	OptionPane.warningDialog.titlePane.background	javax.swing.plaf.ColorUIResource[r=255,g=204,b=153]
        // 	OptionPane.warningDialog.titlePane.foreground	javax.swing.plaf.ColorUIResource[r=102,g=51,b=0]
        // 	OptionPane.warningDialog.titlePane.shadow	javax.swing.plaf.ColorUIResource[r=204,g=153,b=102]
        // 	OptionPane.warningIcon	sun.swing.ImageIconUIResource@532760d8
        // 	OptionPane.warningSound	sounds/OptionPaneWarning.wav
        // 	OptionPane.windowBindings	[Ljava.lang.Object;@443b7951
        // 	OptionPaneUI	javax.swing.plaf.basic.BasicOptionPaneUI
        // 	Panel.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Panel.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	Panel.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	PanelUI	javax.swing.plaf.basic.BasicPanelUI
        // 	PasswordField.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	PasswordField.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@69222c14
        // 	PasswordField.caretBlinkRate	500
        // 	PasswordField.caretForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	PasswordField.echoChar	•
        // 	PasswordField.focusInputMap	javax.swing.plaf.InputMapUIResource@2a3046da
        // 	PasswordField.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	PasswordField.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	PasswordField.inactiveBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	PasswordField.inactiveForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	PasswordField.margin	javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0]
        // 	PasswordField.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	PasswordField.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	PasswordFieldUI	javax.swing.plaf.basic.BasicPasswordFieldUI
        // 	PopupMenu.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	PopupMenu.border	javax.swing.plaf.metal.MetalBorders$PopupMenuBorder@39a054a5
        // 	PopupMenu.consumeEventOnClose	false
        // 	PopupMenu.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	PopupMenu.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	PopupMenu.popupSound	sounds/PopupMenuPopup.wav
        // 	PopupMenu.selectedWindowInputMapBindings	[Ljava.lang.Object;@484b61fc
        // 	PopupMenu.selectedWindowInputMapBindings.RightToLeft	[Ljava.lang.Object;@15327b79
        // 	PopupMenuSeparatorUI	javax.swing.plaf.metal.MetalPopupMenuSeparatorUI
        // 	PopupMenuUI	javax.swing.plaf.basic.BasicPopupMenuUI
        // 	ProgressBar.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ProgressBar.border	javax.swing.plaf.BorderUIResource$LineBorderUIResource@7b3300e5
        // 	ProgressBar.cellLength	1
        // 	ProgressBar.cellSpacing	0
        // 	ProgressBar.cycleTime	3000
        // 	ProgressBar.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	ProgressBar.foreground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	ProgressBar.horizontalSize	javax.swing.plaf.DimensionUIResource[width=146,height=12]
        // 	ProgressBar.repaintInterval	50
        // 	ProgressBar.selectionBackground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	ProgressBar.selectionForeground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ProgressBar.verticalSize	javax.swing.plaf.DimensionUIResource[width=12,height=146]
        // 	ProgressBarUI	javax.swing.plaf.metal.MetalProgressBarUI
        // 	RadioButton.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	RadioButton.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@19e1023e
        // 	RadioButton.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	RadioButton.disabledText	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	RadioButton.focus	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	RadioButton.focusInputMap	javax.swing.plaf.InputMapUIResource@71dac704
        // 	RadioButton.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	RadioButton.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	RadioButton.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	RadioButton.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	RadioButton.icon	javax.swing.plaf.metal.MetalIconFactory$RadioButtonIcon@16f65612
        // 	RadioButton.light	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	RadioButton.margin	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2]
        // 	RadioButton.rollover	true
        // 	RadioButton.select	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	RadioButton.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	RadioButton.textIconGap	4
        // 	RadioButton.textShiftOffset	0
        // 	RadioButton.totalInsets	java.awt.Insets[top=4,left=4,bottom=4,right=4]
        // 	RadioButtonMenuItem.acceleratorFont	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=10]
        // 	RadioButtonMenuItem.acceleratorForeground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	RadioButtonMenuItem.acceleratorSelectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	RadioButtonMenuItem.arrowIcon	javax.swing.plaf.metal.MetalIconFactory$MenuItemArrowIcon@5e91993f
        // 	RadioButtonMenuItem.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	RadioButtonMenuItem.border	javax.swing.plaf.metal.MetalBorders$MenuItemBorder@1e81f4dc
        // 	RadioButtonMenuItem.borderPainted	true
        // 	RadioButtonMenuItem.checkIcon	javax.swing.plaf.metal.MetalIconFactory$RadioButtonMenuItemIcon@2a098129
        // 	RadioButtonMenuItem.commandSound	sounds/MenuItemCommand.wav
        // 	RadioButtonMenuItem.disabledForeground	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	RadioButtonMenuItem.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	RadioButtonMenuItem.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	RadioButtonMenuItem.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	RadioButtonMenuItem.margin	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=2]
        // 	RadioButtonMenuItem.selectionBackground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	RadioButtonMenuItem.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	RadioButtonMenuItemUI	javax.swing.plaf.basic.BasicRadioButtonMenuItemUI
        // 	RadioButtonUI	javax.swing.plaf.metal.MetalRadioButtonUI
        // 	RootPane.ancestorInputMap	javax.swing.plaf.InputMapUIResource@14899482
        // 	RootPane.colorChooserDialogBorder	javax.swing.plaf.metal.MetalBorders$QuestionDialogBorder@379619aa
        // 	RootPane.defaultButtonWindowKeyBindings	[Ljava.lang.Object;@66cd51c3
        // 	RootPane.errorDialogBorder	javax.swing.plaf.metal.MetalBorders$ErrorDialogBorder@63e31ee
        // 	RootPane.fileChooserDialogBorder	javax.swing.plaf.metal.MetalBorders$QuestionDialogBorder@2437c6dc
        // 	RootPane.frameBorder	javax.swing.plaf.metal.MetalBorders$FrameBorder@311d617d
        // 	RootPane.informationDialogBorder	javax.swing.plaf.metal.MetalBorders$DialogBorder@7382f612
        // 	RootPane.plainDialogBorder	javax.swing.plaf.metal.MetalBorders$DialogBorder@5c8da962
        // 	RootPane.questionDialogBorder	javax.swing.plaf.metal.MetalBorders$QuestionDialogBorder@2c13da15
        // 	RootPane.warningDialogBorder	javax.swing.plaf.metal.MetalBorders$WarningDialogBorder@5679c6c6
        // 	RootPaneUI	javax.swing.plaf.metal.MetalRootPaneUI

        // 	scrollbar	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.allowsAbsolutePositioning	true
        // 	ScrollBar.ancestorInputMap	javax.swing.plaf.InputMapUIResource@123a439b
        // 	ScrollBar.ancestorInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@470e2030
        // 	ScrollBar.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ScrollBar.foreground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	ScrollBar.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ScrollBar.maximumThumbSize	javax.swing.plaf.DimensionUIResource[width=4096,height=4096]
        // 	ScrollBar.minimumThumbSize	javax.swing.plaf.DimensionUIResource[width=8,height=8]
        // 	ScrollBar.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ScrollBar.thumb	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	ScrollBar.thumbDarkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ScrollBar.thumbHighlight	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ScrollBar.thumbShadow	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	ScrollBar.track	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.trackHighlight	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ScrollBar.width	17
        // 	ScrollBarUI	javax.swing.plaf.metal.MetalScrollBarUI

        // 	ScrollPane.ancestorInputMap	javax.swing.plaf.InputMapUIResource@1edf1c96
        // 	ScrollPane.ancestorInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@5aaa6d82
        // 	ScrollPane.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollPane.border	javax.swing.plaf.metal.MetalBorders$ScrollPaneBorder@2e5c649
        // 	ScrollPane.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	ScrollPane.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ScrollPaneUI	javax.swing.plaf.metal.MetalScrollPaneUI

        // 	Separator.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Separator.foreground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	Separator.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Separator.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	SeparatorUI	javax.swing.plaf.metal.MetalSeparatorUI

        // 	Slider.altTrackColor	javax.swing.plaf.ColorUIResource[r=210,g=226,b=239]
        // 	Slider.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Slider.focus	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	Slider.focusGradient	[0.3, 0.2, javax.swing.plaf.ColorUIResource[r=200,g=221,b=242], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	Slider.focusInputMap	javax.swing.plaf.InputMapUIResource@8807e25
        // 	Slider.focusInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@6ed3ef1
        // 	Slider.focusInsets	javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0]
        // 	Slider.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	Slider.foreground	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	Slider.gradient	[0.3, 0.2, javax.swing.plaf.ColorUIResource[r=200,g=221,b=242], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	Slider.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Slider.horizontalSize	java.awt.Dimension[width=200,height=21]
        // 	Slider.horizontalThumbIcon	javax.swing.plaf.metal.MetalIconFactory$OceanHorizontalSliderThumbIcon@2401f4c3
        // 	Slider.majorTickLength	6
        // 	Slider.minimumHorizontalSize	java.awt.Dimension[width=36,height=21]
        // 	Slider.minimumVerticalSize	java.awt.Dimension[width=21,height=36]
        // 	Slider.onlyLeftMouseButtonDrag	true
        // 	Slider.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Slider.tickColor	java.awt.Color[r=0,g=0,b=0]
        // 	Slider.trackWidth	7
        // 	Slider.verticalSize	java.awt.Dimension[width=21,height=200]
        // 	Slider.verticalThumbIcon	javax.swing.plaf.metal.MetalIconFactory$OceanVerticalSliderThumbIcon@5d22bbb7
        // 	SliderUI	javax.swing.plaf.metal.MetalSliderUI
        // 	Spinner.ancestorInputMap	javax.swing.plaf.InputMapUIResource@3fb4f649
        // 	Spinner.arrowButtonBorder	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@77468bd9
        // 	Spinner.arrowButtonInsets	javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0]
        // 	Spinner.arrowButtonSize	java.awt.Dimension[width=16,height=5]
        // 	Spinner.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Spinner.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@69222c14
        // 	Spinner.editorAlignment	11
        // 	Spinner.editorBorderPainted	false
        // 	Spinner.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	Spinner.foreground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	SpinnerUI	javax.swing.plaf.basic.BasicSpinnerUI
        // 	SplitPane.ancestorInputMap	javax.swing.plaf.InputMapUIResource@567d299b
        // 	SplitPane.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	SplitPane.border	javax.swing.plaf.basic.BasicBorders$SplitPaneBorder@6bc168e5
        // 	SplitPane.centerOneTouchButtons	false
        // 	SplitPane.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	SplitPane.dividerFocusColor	javax.swing.plaf.ColorUIResource[r=200,g=221,b=242]
        // 	SplitPane.dividerSize	10
        // 	SplitPane.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	SplitPane.oneTouchButtonsOpaque	false
        // 	SplitPane.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	SplitPaneDivider.border	javax.swing.plaf.basic.BasicBorders$SplitPaneDividerBorder@4926097b
        // 	SplitPaneDivider.draggingColor	javax.swing.plaf.ColorUIResource[r=64,g=64,b=64]
        // 	SplitPaneUI	javax.swing.plaf.metal.MetalSplitPaneUI
        // 	TabbedPane.ancestorInputMap	javax.swing.plaf.InputMapUIResource@555590
        // 	TabbedPane.background	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TabbedPane.borderHightlightColor	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	TabbedPane.contentAreaColor	javax.swing.plaf.ColorUIResource[r=200,g=221,b=242]
        // 	TabbedPane.contentBorderInsets	java.awt.Insets[top=4,left=2,bottom=3,right=3]
        // 	TabbedPane.contentOpaque	true
        // 	TabbedPane.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	TabbedPane.focus	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	TabbedPane.focusInputMap	javax.swing.plaf.InputMapUIResource@4141d797
        // 	TabbedPane.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	TabbedPane.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TabbedPane.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TabbedPane.labelShift	1
        // 	TabbedPane.light	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	TabbedPane.selected	javax.swing.plaf.ColorUIResource[r=200,g=221,b=242]
        // 	TabbedPane.selectedLabelShift	-1
        // 	TabbedPane.selectedTabPadInsets	javax.swing.plaf.InsetsUIResource[top=2,left=2,bottom=2,right=1]
        // 	TabbedPane.selectHighlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TabbedPane.selectionFollowsFocus	true
        // 	TabbedPane.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TabbedPane.tabAreaBackground	javax.swing.plaf.ColorUIResource[r=218,g=218,b=218]
        // 	TabbedPane.tabAreaInsets	java.awt.Insets[top=2,left=2,bottom=0,right=6]
        // 	TabbedPane.tabInsets	javax.swing.plaf.InsetsUIResource[top=0,left=9,bottom=1,right=9]
        // 	TabbedPane.tabRunOverlay	2
        // 	TabbedPane.tabsOpaque	true
        // 	TabbedPane.tabsOverlapBorder	false
        // 	TabbedPane.textIconGap	4
        // 	TabbedPane.unselectedBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	TabbedPaneUI	javax.swing.plaf.metal.MetalTabbedPaneUI
        // 	Table.ancestorInputMap	javax.swing.plaf.InputMapUIResource@2f333739
        // 	Table.ancestorInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@123772c4
        // 	Table.ascendingSortIcon	sun.swing.ImageIconUIResource@64b8f8f4
        // 	Table.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Table.descendingSortIcon	sun.swing.ImageIconUIResource@3339ad8e
        // 	Table.dropCellBackground	javax.swing.plaf.ColorUIResource[r=210,g=233,b=255]
        // 	Table.dropLineColor	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	Table.dropLineShortColor	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Table.focusCellBackground	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Table.focusCellForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Table.focusCellHighlightBorder	javax.swing.plaf.BorderUIResource$LineBorderUIResource@43556938
        // 	Table.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	Table.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Table.gridColor	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	Table.scrollPaneBorder	javax.swing.plaf.metal.MetalBorders$ScrollPaneBorder@65ae6ba4
        // 	Table.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Table.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Table.sortIconColor	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TableHeader.ancestorInputMap	javax.swing.plaf.InputMapUIResource@cac736f
        // 	TableHeader.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	TableHeader.cellBorder	javax.swing.plaf.metal.MetalBorders$TableHeaderBorder@368102c8
        // 	TableHeader.focusCellBackground	javax.swing.plaf.ColorUIResource[r=200,g=221,b=242]
        // 	TableHeader.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	TableHeader.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TableHeaderUI	javax.swing.plaf.basic.BasicTableHeaderUI
        // 	TableUI	javax.swing.plaf.basic.BasicTableUI
        // 	text	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TextArea.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TextArea.border	javax.swing.plaf.basic.BasicBorders$MarginBorder@182decdb
        // 	TextArea.caretBlinkRate	500
        // 	TextArea.caretForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextArea.focusInputMap	javax.swing.plaf.InputMapUIResource@77afea7d
        // 	TextArea.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	TextArea.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextArea.inactiveForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextArea.margin	javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0]
        // 	TextArea.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextArea.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextAreaUI	javax.swing.plaf.basic.BasicTextAreaUI
        // 	TextField.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TextField.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@69222c14
        // 	TextField.caretBlinkRate	500
        // 	TextField.caretForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextField.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	TextField.focusInputMap	javax.swing.plaf.InputMapUIResource@75a1cd57
        // 	TextField.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	TextField.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextField.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TextField.inactiveBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	TextField.inactiveForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextField.light	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TextField.margin	javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0]
        // 	TextField.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextField.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextField.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextFieldUI	javax.swing.plaf.metal.MetalTextFieldUI
        // 	textHighlight	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	textHighlightText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	textInactiveText	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextPane.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	TextPane.border	javax.swing.plaf.basic.BasicBorders$MarginBorder@e73f9ac
        // 	TextPane.caretBlinkRate	500
        // 	TextPane.caretForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextPane.focusInputMap	javax.swing.plaf.InputMapUIResource@3caeaf62
        // 	TextPane.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	TextPane.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextPane.inactiveForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextPane.margin	javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3]
        // 	TextPane.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	TextPane.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TextPaneUI	javax.swing.plaf.basic.BasicTextPaneUI
        // 	textText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	TitledBorder.border	javax.swing.plaf.BorderUIResource$LineBorderUIResource@6f2b958e
        // 	TitledBorder.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	TitledBorder.titleColor	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ToggleButton.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ToggleButton.border	javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@57fa26b7
        // 	ToggleButton.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ToggleButton.disabledText	javax.swing.plaf.ColorUIResource[r=153,g=153,b=153]
        // 	ToggleButton.focus	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	ToggleButton.focusInputMap	javax.swing.plaf.InputMapUIResource@3d012ddd
        // 	ToggleButton.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	ToggleButton.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ToggleButton.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	ToggleButton.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ToggleButton.light	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ToggleButton.margin	javax.swing.plaf.InsetsUIResource[top=2,left=14,bottom=2,right=14]
        // 	ToggleButton.select	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ToggleButton.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ToggleButton.textIconGap	4
        // 	ToggleButton.textShiftOffset	0
        // 	ToggleButtonUI	javax.swing.plaf.metal.MetalToggleButtonUI
        // 	ToolBar.ancestorInputMap	javax.swing.plaf.InputMapUIResource@2db0f6b2
        // 	ToolBar.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ToolBar.border	javax.swing.plaf.metal.MetalBorders$ToolBarBorder@75828a0f
        // 	ToolBar.borderColor	javax.swing.plaf.ColorUIResource[r=204,g=204,b=204]
        // 	ToolBar.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ToolBar.dockingBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ToolBar.dockingForeground	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	ToolBar.floatingBackground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ToolBar.floatingForeground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ToolBar.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=bold,size=12]
        // 	ToolBar.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ToolBar.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ToolBar.isRollover	true
        // 	ToolBar.light	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ToolBar.nonrolloverBorder	javax.swing.border.CompoundBorder@515f550a
        // 	ToolBar.rolloverBorder	javax.swing.border.CompoundBorder@2d363fb3
        // 	ToolBar.separatorSize	javax.swing.plaf.DimensionUIResource[width=10,height=10]
        // 	ToolBar.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ToolBarSeparatorUI	javax.swing.plaf.basic.BasicToolBarSeparatorUI
        // 	ToolBarUI	javax.swing.plaf.metal.MetalToolBarUI
        // 	ToolTip.background	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ToolTip.backgroundInactive	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ToolTip.border	javax.swing.plaf.BorderUIResource$LineBorderUIResource@512ddf17
        // 	ToolTip.borderInactive	javax.swing.plaf.BorderUIResource$LineBorderUIResource@3830f1c0
        // 	ToolTip.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	ToolTip.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ToolTip.foregroundInactive	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ToolTip.hideAccelerator	false
        // 	ToolTipManager.enableToolTipMode	activeApplication
        // 	ToolTipUI	javax.swing.plaf.metal.MetalToolTipUI
        // 	Tree.ancestorInputMap	javax.swing.plaf.InputMapUIResource@47089e5f
        // 	Tree.background	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Tree.changeSelectionWithFocus	true
        // 	Tree.closedIcon	sun.swing.ImageIconUIResource@707f7052
        // 	Tree.collapsedIcon	javax.swing.plaf.metal.OceanTheme$COIcon@4c3e4790
        // 	Tree.drawsFocusBorderAroundIcon	false
        // 	Tree.dropCellBackground	javax.swing.plaf.ColorUIResource[r=210,g=233,b=255]
        // 	Tree.dropLineColor	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	Tree.editorBorder	javax.swing.plaf.BorderUIResource$LineBorderUIResource@156643d4
        // 	Tree.expandedIcon	sun.swing.ImageIconUIResource@12f40c25
        // 	Tree.focusInputMap	javax.swing.plaf.InputMapUIResource@136432db
        // 	Tree.focusInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@73a28541
        // 	Tree.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	Tree.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Tree.hash	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Tree.leafIcon	sun.swing.ImageIconUIResource@6504e3b2
        // 	Tree.leftChildIndent	7
        // 	Tree.line	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Tree.lineTypeDashed	false
        // 	Tree.openIcon	sun.swing.ImageIconUIResource@1175e2db
        // 	Tree.paintLines	true
        // 	Tree.rightChildIndent	13
        // 	Tree.rowHeight	0
        // 	Tree.scrollsOnExpand	true
        // 	Tree.selectionBackground	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	Tree.selectionBorderColor	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	Tree.selectionForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Tree.textBackground	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	Tree.textForeground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	Tree.timeFactor	1000
        // 	TreeUI	javax.swing.plaf.metal.MetalTreeUI
        // 	Viewport.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	Viewport.font	javax.swing.plaf.FontUIResource[family=Dialog,name=Dialog,style=plain,size=12]
        // 	Viewport.foreground	sun.swing.PrintColorUIResource[r=51,g=51,b=51]
        // 	ViewportUI	javax.swing.plaf.basic.BasicViewportUI
        // 	window	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	windowBorder	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	windowText	sun.swing.PrintColorUIResource[r=51,g=51,b=51]

        Font f = new Font("Segoe UI", Font.PLAIN, 14);
        //Font f = new Font("Courier New", Font.PLAIN, 10);
        UIManager.put("Button.font", f);
        UIManager.put("ToggleButton.font", f);
        UIManager.put("RadioButton.font", f);
        UIManager.put("CheckBox.font", f);
        UIManager.put("ColorChooser.font", f);
        UIManager.put("ComboBox.font", f);
        UIManager.put("Label.font", f);
        UIManager.put("List.font", f);
        UIManager.put("MenuBar.font", f);
        UIManager.put("MenuItem.font", f);
        UIManager.put("RadioButtonMenuItem.font", f);
        UIManager.put("CheckBoxMenuItem.font", f);
        UIManager.put("Menu.font", f);
        UIManager.put("PopupMenu.font", f);
        UIManager.put("OptionPane.font", f);
        UIManager.put("Panel.font", f);
        UIManager.put("ProgressBar.font", f);
        UIManager.put("ScrollPane.font", f);
        UIManager.put("Viewport.font", f);
        UIManager.put("TabbedPane.font", f);
        UIManager.put("Table.font", f);
        UIManager.put("TableHeader.font", f);
        UIManager.put("TextField.font", f);
        UIManager.put("PasswordField.font", f);
        UIManager.put("TextArea.font", f);
        UIManager.put("TextPane.font", f);
        UIManager.put("EditorPane.font", f);
        UIManager.put("TitledBorder.font", f);
        UIManager.put("ToolBar.font", f);
        UIManager.put("ToolTip.font", f);
        UIManager.put("Tree.font", f);

        Color white = Color.white;
        Color black = Color.black;
        Color gray = Color.gray;

        UIManager.put("control", white); // Цвет кнопок на скроле
        UIManager.put("Button.background", white);
        UIManager.put("Button.focus", white); // Цвет рамки вокруг нажатой кнопки
        UIManager.put("Button.select", white); // Цвет кнопки вовремя нажатия
        UIManager.put("CheckBox.background", white);
        UIManager.put("ComboBox.background", white);
        UIManager.put("ComboBox.buttonBackground", white);
        UIManager.put("Panel.background", white);

        UIManager.put("ScrollBar.background", white);
        UIManager.put("ScrollBar.shadow", white); // Внутренний контур полосы прокрутки
        UIManager.put("ScrollBar.thumbHighlight", white); // Тень на бегунке
        UIManager.put("ScrollBar.thumbShadow", gray); // Внешний контур бегунка
        UIManager.put("ScrollBar.darkShadow", gray); // Внешний Контур полосы прокрутки

        UIManager.put("ScrollPane.background", white); // Бекграунд скрол панели

        UIManager.put("ScrollBar.gradient", Arrays.asList(0.0, 0.0, white, white, white)); // Центральный градиент бегунка
        UIManager.put("ScrollBar.width", 14);


        // 	scrollbar	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.allowsAbsolutePositioning	true
        // 	ScrollBar.ancestorInputMap	javax.swing.plaf.InputMapUIResource@123a439b
        // 	ScrollBar.ancestorInputMap.RightToLeft	javax.swing.plaf.InputMapUIResource@470e2030
        // 	ScrollBar.background	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.darkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ScrollBar.foreground	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.gradient	[0.3, 0.0, javax.swing.plaf.ColorUIResource[r=221,g=232,b=243], javax.swing.plaf.ColorUIResource[r=255,g=255,b=255], javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]]
        // 	ScrollBar.highlight	javax.swing.plaf.ColorUIResource[r=255,g=255,b=255]
        // 	ScrollBar.maximumThumbSize	javax.swing.plaf.DimensionUIResource[width=4096,height=4096]
        // 	ScrollBar.minimumThumbSize	javax.swing.plaf.DimensionUIResource[width=8,height=8]
        // 	ScrollBar.shadow	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ScrollBar.thumb	javax.swing.plaf.ColorUIResource[r=163,g=184,b=204]
        // 	ScrollBar.thumbDarkShadow	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ScrollBar.thumbHighlight	javax.swing.plaf.ColorUIResource[r=184,g=207,b=229]
        // 	ScrollBar.thumbShadow	javax.swing.plaf.ColorUIResource[r=99,g=130,b=191]
        // 	ScrollBar.track	javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]
        // 	ScrollBar.trackHighlight	javax.swing.plaf.ColorUIResource[r=122,g=138,b=153]
        // 	ScrollBar.width	17
        // 	ScrollBarUI	javax.swing.plaf.metal.MetalScrollBarUI

    }

    public static void main(String[] args) throws Exception {
        setStyle();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        //Manager manager = applicationContext.getBean("manager", Manager.class);
        //MainFrame frame = applicationContext.getBean("gui-main-frame", MainFrame.class);
        //frame.setManager(manager);
        //frame.afterPropertiesSet();
    }
}
