

# pack()

The pack method sizes the frame so that all its contents are at or above their preferred sizes. An alternative to pack is to establish a frame size explicitly by calling setSize or setBounds (which also sets the frame location). In general, using pack is preferable to calling setSize, since pack leaves the frame layout manager in charge of the frame size, and layout managers are good at adjusting to platform dependencies and other factors that affect component size.

# Intellj GUI Designer:

## Pre-requisties:

- Make sure that you have `GUI designer` settings in intellj ---> generated gui set to java source code.
- To make a jar file with maven, you need that jar file plugin under build tag ---> Make sure that your main class points to where your `main` method implementing class is. Everything else is unnecessary.
- Give the audio file's absolute path for the timer, in `src\main\java\AudioControl`
I could not package the audio file with the jar as I cannot access it within the jar

Explanations on how individual thing works is given in BreakPanel and EyeCare