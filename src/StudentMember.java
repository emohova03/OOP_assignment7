class StudentMember extends Member {
    public StudentMember(String id, String name) {
        super(id, name);
    }

    @Override
    protected int getBorrowLimit() {
        return 3;
    }
}
