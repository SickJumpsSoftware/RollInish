package com.sickjumps.rollinish.character;

/**
 *
 * @author Nathan
 */

public class Monster extends Participant {

    // "Name", "Size", "Type", "Tag", "Alignment", "CR", "XP", "Source"
    private Size size;
    private Type type;
    private Alignment alignment;
    private String challenge;
    private int xp;
    private String source;
    private String tag;
    
    public Monster(int dexMod, String name, Type type, String tag, Alignment alignment, String challenge, int xp, String source) {
        super(name, "DM", dexMod);
        this.type = type;
        this.tag = tag;
        this.alignment = alignment;
        this.challenge = challenge;
        this.xp = xp;
        this.source = source;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
