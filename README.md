### ColorChanger is my first Android app.
#### The idea and functionality are simple; the process of writing, styling, and publishing the app was the real learning experience.
##### Note: being my first app, I simply pushed the entire project from Android Studio onto GitHub, so there may be extraneous files here that will remain while I am in the process of cleaning it up.

#### Main Activity description:
1. Initially, the user sees a white screen with 3 buttons, 4 text fields, and 4 edit-text fields.
2. The top button ("random color") changes the background of the View to be a pseudo-random color by creating three random ints (r,g,b) and setting the background color with these ints as Red, Green, and Blue values.
3. The random button also sets the "R:", "G:", and "B:" input fields to be the respective generated numbers, as well as the "HEX:" input field ot be the corresponding hexadecimal color value.
4. The user could also manually type R, G, and B values and press the middle button ("check rgb") to change the screen color and update the HEX input field.
5. Finally, the user could manually type a HEX color code, with a leading \#, and press the bottom button ("check hex") to change the screen color and update the R,G, and B input fields.