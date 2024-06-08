import java.awt.event.*;

public class KeyResponse implements KeyListener{

    Display display;
    public boolean displayed;
    public int pressedKey;
    public boolean backPressed;
    public boolean nextPressed;

    public KeyResponse(Display display) {
        this.display = display;
        displayed = false;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_1) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 0;
            } else {
                displayed = false;
            }
        } 
        if (code == KeyEvent.VK_2) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 1;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_3) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 2;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_4) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 3;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_5) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 4;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_6) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 5;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_7) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 6;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_8) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 7;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_9) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 8;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_0) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 9;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_Q) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 10;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_W) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 11;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_E) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 12;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_R) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 13;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_T) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 14;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_Y) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 15;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_A) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 16;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_S) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 17;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_D) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 18;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_F) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 19;
            } else {
                displayed = false;
            }
        }
        if (code == KeyEvent.VK_G) {
            if (displayed = false) {
                displayed = true;
                pressedKey = 20;
            } else {
                displayed = false;
            }

        }
        if (code == KeyEvent.VK_B) {
            backPressed = true;
        }
        if (code == KeyEvent.VK_ENTER) {
            nextPressed = true;
        }

    }

    public int getPressedKey() {
        return pressedKey;
    }
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_B) {
            backPressed = false;
        }
        if (code == KeyEvent.VK_ENTER) {
            nextPressed = false;
        }
    }
}
