package com.sickjumps.rollinish.campaign.character;

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

    public Monster(String name, Size size, Type type, Alignment alignment, String challenge, int xp, String source, String tag) {
        super(name, "DM", 0);
        this.size = size;
        this.type = type;
        this.alignment = alignment;
        this.challenge = challenge;
        this.xp = xp;
        this.source = source;
        this.tag = tag;
    }

    public Monster(String characterName, int dexMod) {
        super(characterName, "DM", dexMod);
        this.size = Size.GARGANTUAN;
        this.type = Type.ABERRATION;
        this.alignment = Alignment.CE;
        this.challenge = "";
        this.xp = 0;
        this.source = "";
        this.tag = "";
    }

    public String getName() {
        return super.getCharacterName();
    }

    public void setName(String name) {
        super.setCharacterName(name);
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

    @Override
    public String toString() {
        String prefix = super.toString();
        return prefix + " || Monster{" + "size=" + size + ", type=" + type + ", alignment=" + alignment + ", challenge=" + challenge + ", xp=" + xp + ", source=" + source + ", tag=" + tag + '}';
    }
}
