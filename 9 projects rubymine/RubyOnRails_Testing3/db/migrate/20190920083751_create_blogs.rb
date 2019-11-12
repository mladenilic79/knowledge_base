class CreateBlogs < ActiveRecord::Migration[6.0]
  def change
    create_table :blogs do |t|
      t.string :blog_name
      t.integer :blog_number

      t.timestamps
    end
  end
end
