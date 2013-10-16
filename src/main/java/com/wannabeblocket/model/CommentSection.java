package com.wannabeblocket.model;

public class CommentSection extends AbstractDAO<Comment, Long> {

    public CommentSection(String puName) {
        super(Comment.class, puName);
    }

    /**
     *
     * @param comment
     */
    public void submitComment(Comment comment) {
        // TODO - implement CommentSection.submitComment
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void deleteComment(int id) {
        // TODO - implement CommentSection.deleteComment
        throw new UnsupportedOperationException();
    }

    public Comment[] getCommentThread() {
        // TODO - implement CommentSection.getCommentThread
        throw new UnsupportedOperationException();
    }
}
