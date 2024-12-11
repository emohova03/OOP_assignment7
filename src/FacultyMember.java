class FacultyMember extends Member {
    public FacultyMember(String id, String name) {
        super(id, name);
    }

    @Override
    protected int getBorrowLimit() {
        return 5;
    }
}

