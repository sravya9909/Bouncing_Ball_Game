# Bouncing_Ball_Game

## Bounce Applet

This Java applet creates an interactive bouncing ball animation with start and stop controls. Here's a breakdown of its key features:

### Features

- A blue ball that bounces within the applet window
- "Start" and "Stop" buttons to control the animation
- Smooth animation using double buffering
- Ball changes direction upon hitting window boundaries

### How It Works

1. The applet initializes with a blue ball and two control buttons.
2. Clicking "Start" begins or resumes the ball's movement.
3. Clicking "Stop" pauses the animation and reverses the ball's horizontal direction.
4. The ball bounces off the window edges, changing direction automatically.
5. The animation runs in a separate thread for smooth performance.

### Technical Details

- Uses Java AWT for graphics and user interface
- Implements `Runnable` interface for multi-threading
- Utilizes double buffering technique for flicker-free animation
- Custom event handling for button actions

### Usage

To run this applet, include it in an HTML file with the following tag:

```html
<applet code="Bounce" width="300" height="300">
</applet>
```

This project demonstrates basic game loop principles, event handling, and graphics manipulation in Java applets.
