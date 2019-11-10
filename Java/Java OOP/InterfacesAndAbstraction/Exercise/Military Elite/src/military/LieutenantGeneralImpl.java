package military;

import military.interfaces.LieutenantGeneral;
import military.interfaces.Private;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);

        this.privates = new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private f, Private s) {
                return s.getId() - f.getId();
            }
        });
    }

    public Collection<Private> getPrivates() {
        return privates;
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        for (Private soldier : privates) {
            sb.append("  ")
                    .append(soldier.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
