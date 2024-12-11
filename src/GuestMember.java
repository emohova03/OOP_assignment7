class GuestMember extends Member {
    public GuestMember(String id, String name) {
        super(id, name);
    }

    @Override
    protected int getBorrowLimit() {
        return 1;
    }
}