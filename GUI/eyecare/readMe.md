

# pack()

The pack method sizes the frame so that all its contents are at or above their preferred sizes. An alternative to pack is to establish a frame size explicitly by calling setSize or setBounds (which also sets the frame location). In general, using pack is preferable to calling setSize, since pack leaves the frame layout manager in charge of the frame size, and layout managers are good at adjusting to platform dependencies and other factors that affect component size.

# Intellj GUI Designer:

## Pre-requisties:

- Make sure that you have `GUI designer` settings in intellj ---> generated gui set to java source code.
- To deploy, create a new artifact with `file\project_structure\` and new jar file artifact from existing dependencies - make sure it points to that class with `main` method implemented.

Explanations on how individual thing works is given in BreakPanel