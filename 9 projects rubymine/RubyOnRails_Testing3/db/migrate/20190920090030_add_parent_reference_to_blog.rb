class AddParentReferenceToBlog < ActiveRecord::Migration[6.0]
  def change
    add_reference :blogs, :parent, null: false, foreign_key: true
  end
end
