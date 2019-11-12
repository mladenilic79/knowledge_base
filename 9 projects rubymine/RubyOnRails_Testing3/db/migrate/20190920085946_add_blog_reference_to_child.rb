class AddBlogReferenceToChild < ActiveRecord::Migration[6.0]
  def change
    add_reference :children, :blog, null: false, foreign_key: true
  end
end
